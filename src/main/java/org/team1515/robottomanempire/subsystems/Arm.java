package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.subsystems.encoders.ArmEncoder;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {

	private PIDControllableMotor motors;
	private DigitalInput limitSwitch;

	private static final double RAISE_SPEED = RobotMap.ARM_RAISE_SPEED;
	private static final double LOWER_SPEED = RobotMap.ARM_LOWER_SPEED;
	private static final double HOLD_SPEED = RobotMap.ARM_HOLD_SPEED;

	private static final double MIN_ANGLE = RobotMap.ARM_MIN_ANGLE;
	private static final double MAX_ANGLE = RobotMap.ARM_MAX_ANGLE;

	public Arm() {
		motors = new PIDControllableMotor(RobotMap.ARM_TALON_IDS, RobotMap.ARM_PID_CONSTANTS, new ArmEncoder(RobotMap.ARM_ENCODER_ID), 0.5);
		limitSwitch = new DigitalInput(RobotMap.ARM_LIMIT_SWITCH_ID);
		motors.resetEncoder();
	}

	public void raise() {
		motors.setSpeed(-RAISE_SPEED);
	}

	public void lower() {
		motors.setSpeed(LOWER_SPEED);
	}

	public void setAngle(double angle) {
		motors.setSpeedPID(angle);
	}

	public double getAngle() {
		return motors.getEncoderMeasurement();
	}

	public void hold() {
		motors.setSpeed(-HOLD_SPEED);
	}

	public void stop() {
		motors.stop();
	}

	public boolean isAtMaxAngle() {
		return getAngle() < MAX_ANGLE;
	}

	public boolean isAtMinAngle() {
		return getAngle() > MIN_ANGLE;
	}

	public void printPID() {
		motors.print("arm");
		SmartDashboard.putNumber("arm", motors.getEncoderMeasurement());
	}

	@Override
	protected void initDefaultCommand() {

	}

}
