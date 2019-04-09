package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.subsystems.encoders.ShooterEncoder;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private PIDControllableMotor topMotor;
	private PIDControllableMotor bottomMotor;

	private Piston piston;
	private DigitalInput limitSwitch;

	private static final double SHOOTING_SPEED = RobotMap.SHOOTING_SPEED;
	private static final double FAST_SHOOTING_SPEED = RobotMap.FAST_SHOOTING_SPEED;
	private static final double INTAKE_SPEED = RobotMap.INTAKE_SPEED;

	public Shooter() {
		topMotor = new PIDControllableMotor(RobotMap.TOP_SHOOTER_TALON_IDS,  RobotMap.TOP_SHOOTER_PID_CONSTANTS, new ShooterEncoder(RobotMap.TOP_SHOOTER_ENCODER_ID, RobotMap.TOP_SHOOTER_ENCODER_REVERSED));
		bottomMotor = new PIDControllableMotor(RobotMap.BOTTOM_SHOOTER_TALON_IDS, RobotMap.BOTTOM_SHOOTER_PID_CONSTANTS, new ShooterEncoder(RobotMap.BOTTOM_SHOOTER_ENCODER_ID, RobotMap.BOTTOM_SHOOTER_ENCODER_REVERSED));
		piston = new Piston(RobotMap.SHOOTER_SOLENOID_ID);
		limitSwitch = new DigitalInput(RobotMap.SHOOTER_LIMIT_SWITCH_ID);

		bottomMotor.resetEncoder();
		topMotor.resetEncoder();
	}

	public void push() {
		piston.extend();
	}

	public void shoot() {
		topMotor.setSpeed(SHOOTING_SPEED);
		bottomMotor.setSpeed(-SHOOTING_SPEED);
	}

	public void shootFast() {
		topMotor.setSpeed(FAST_SHOOTING_SPEED);
		bottomMotor.setSpeed(-FAST_SHOOTING_SPEED);
	}

	public void intake() {
		topMotor.setSpeed(-INTAKE_SPEED);
		bottomMotor.setSpeed(INTAKE_SPEED);
	}

	public void stop() {
		topMotor.stop();
		bottomMotor.stop();
		piston.retract();
	}

	public void printPID() {
		topMotor.print("top shooter");
		bottomMotor.print("bottom shooter");
	}

	public boolean isBallIn()  {
		return !limitSwitch.get();
	}

	@Override
	protected void initDefaultCommand() {

	}

}
