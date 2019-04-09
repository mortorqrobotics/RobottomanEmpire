package org.team1515.robottomanempire.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.team1515.robottomanempire.Controls;
import org.team1515.robottomanempire.Robot;
import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.commands.drivetrain.JoystickDrive;

public class DriveTrain extends Subsystem {

	private PIDControllableMotor leftGearbox;
	private PIDControllableMotor rightGearbox;

	private static final double ROTATE_SIDE = 1.0;
	private static final double ROTATE_CORNER = 0.25;

	private static final double DEADBAND_FORWARD = 0.15;
	private static final double DEADBAND_TWIST = 0.05;

	private static final int DEFAULT_DIRECTION = RobotMap.DRIVETRAIN_DIRECTION;

	private int direction = DEFAULT_DIRECTION;

	private boolean isReducedA = false;
	private boolean isReducedB = false;
	private static final double REDUCED_SPEED_A = 0.66;
	private static final double REDUCED_SPEED_B = 0.33;
	private static final double REDUCED_TURNSPEED = 0.5;

	private boolean isPID = false;

	public DriveTrain() {
		leftGearbox = new PIDControllableMotor(RobotMap.LEFT_DRIVE_TALON_IDS, RobotMap.LEFT_DRIVE_PID_CONSTANTS, RobotMap.LEFT_DRIVE_ENCODER_ID);
		rightGearbox = new PIDControllableMotor(RobotMap.RIGHT_DRIVE_TALON_IDS, RobotMap.RIGHT_DRIVE_PID_CONSTANTS, RobotMap.RIGHT_DRIVE_ENCODER_ID);
	}

	public void setSpeeds(double leftSpeed, double rightSpeed) {
		leftGearbox.setSpeed(leftSpeed);
		rightGearbox.setSpeed(-rightSpeed);
	}

	public void setSpeedsPID(double leftSpeed, double rightSpeed) {
		leftGearbox.setSpeedPID(leftSpeed);
		rightGearbox.setSpeedPID(-rightSpeed);
	}

	public void stop() {
		leftGearbox.stop();
		rightGearbox.stop();
	}

	public void setDefaultDirection() {
		direction = DEFAULT_DIRECTION;
	}

	public void reverse() {
		direction *= -1;
	}

	public void reduceSpeedA() {
		isReducedA = true;
	}

	public void reduceSpeedB() {
		isReducedB = true;
	}

	public void unReduceSpeed() {
		isReducedA = false;
		isReducedB = false;
	}

	public void drive(double forward, double twist) {
		twist *= direction;

		if (isReducedA) {
			forward *= REDUCED_SPEED_A;
			twist *= REDUCED_TURNSPEED;
		} else if (isReducedB) {
			forward *= REDUCED_SPEED_B;
			twist *= REDUCED_TURNSPEED;
		}

		double y = Math.abs(forward);
		double x = Math.abs(twist);
		double a = ROTATE_SIDE;
		double b = ROTATE_CORNER;

		double left = a * x + y * (1 - a * x);
		double right = y * (1 + (a + b - 1) * x) - a * x;
		if (forward < 0) {
			left *= -1;
			right *= -1;
			twist *= -1;
		}
		if (twist > 0) {
			double temp = left;
			left = right;
			right = temp;
		}

		left *= direction * 0.1;
		right *= direction  * 0.1;

		if (isPID) {
			setSpeedsPID(left, right);
		} else {
			setSpeeds(left, right);
		}
	}

	public void joystickDrive() {
		double forward = Robot.driveStick.getRawAxis(Controls.Y_AXIS);
		double twist = -Robot.driveStick.getRawAxis(Controls.X_AXIS);

		forward = Math.abs(forward) > DEADBAND_FORWARD ? forward : 0;
		twist = Math.abs(twist) > DEADBAND_TWIST ? twist : 0;

		drive(forward, twist);
	}

	public void togglePID() {
		isPID = !isPID;
	}

	public double getPosition() {
		return (rightGearbox.getEncoderMeasurement() + leftGearbox.getEncoderMeasurement()) / 2.0;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}

}
