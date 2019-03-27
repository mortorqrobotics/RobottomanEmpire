package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.Robot;
import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	private Piston frontPiston;
	private Piston backPiston;
	private MotorModule motors;

	private static final double SPEED = RobotMap.CLIMBER_DRIVE_SPEED;

	public Climber() {
		frontPiston = new Piston(RobotMap.FRONT_CLIMBER_SOLENOID_ID);
		backPiston = new Piston(RobotMap.BACK_CLIMBER_SOLENOID_ID);
		motors = new MotorModule(RobotMap.CLIMBER_TALON_IDS);
	}

	public void lift() {
		liftFront();
		liftBack();
	}

	public void unlift() {
		retractFront();
		retractBack();
	}

	public void driveForward() {
		motors.setSpeed(SPEED);
	}

	public void stop() {
		motors.stop();
	}

	public void liftFront() {
		frontPiston.extend();
	}

	public void liftBack() {
		backPiston.extend();
	}

	public void retractFront() {
		frontPiston.retract();
	}

	public void retractBack() {
		backPiston.retract();
	}

	@Override
	protected void initDefaultCommand() {

	}

}
