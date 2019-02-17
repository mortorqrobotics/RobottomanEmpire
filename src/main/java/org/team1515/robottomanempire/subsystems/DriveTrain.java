package org.team1515.robottomanempire.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.team1515.robottomanempire.Controls;
import org.team1515.robottomanempire.Robot;
import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.commands.JoystickDrive;

public class DriveTrain extends Subsystem {
	
	private PIDControllableMotor leftGearbox;
	private PIDControllableMotor rightGearbox;
	
	private static final double ROTATE_SIDE = 1.0;
	private static final double ROTATE_CORNER = 0.25;

	private static final double DEADBAND_FORWARD = 0.15;
	private static final double DEADBAND_TWIST = 0.05;

	private int direction = -1; 

	private boolean isReduced = false; 
	private static final double REDUCED_SPEED = 0.75;
	private static final double REDUCED_TURNSPEED = 0.5;

	private boolean isPID = false;
	
	public DriveTrain() {
		leftGearbox = new PIDControllableMotor(RobotMap.LEFT_DRIVE_TALON_IDS, RobotMap.LEFT_DRIVE_PID_CONSTANTS, RobotMap.LEFT_DRIVE_ENCODER_ID);
		rightGearbox = new PIDControllableMotor(RobotMap.RIGHT_DRIVE_TALON_IDS, RobotMap.RIGHT_DRIVE_PID_CONSTANTS, RobotMap.RIGHT_DRIVE_ENCODER_ID);
	}
	
	public void setSpeed(double speed) {
		leftGearbox.setSpeed(speed);
		rightGearbox.setSpeed(-speed);
	}
	
	public void setSpeedPID(double speed) {
		leftGearbox.setSpeedPID(speed);
		rightGearbox.setSpeedPID(-speed);
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
		setSpeed(0);
	}
	
	public void reverse() {
		direction *= -1;
	}

	public void reduceSpeed() {
		isReduced = true;
	}

	public void unReduceSpeed() {
		isReduced = false;
	}

	public void drive() {
		double forward = Robot.driveStick.getRawAxis(Controls.Y_AXIS);
		double twist = -Robot.driveStick.getRawAxis(Controls.X_AXIS);

		forward = Math.abs(forward) > DEADBAND_FORWARD ? forward : 0;
		twist = Math.abs(twist) > DEADBAND_TWIST ? twist : 0;

		twist *= direction;

		if (isReduced) {
			forward *= REDUCED_SPEED;
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

		left *= direction;
		right *= direction;
		
		if (isPID) {
			setSpeedsPID(left, right);
		} else {
			setSpeeds(left, right);
		}
		
	}
		
	public void togglePID() {
		isPID = !isPID;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}

}