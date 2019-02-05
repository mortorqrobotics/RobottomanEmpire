package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private PIDControllableMotor leftMotors;
    public PIDControllableMotor rightMotors;

    private static final double SHOOTING_SPEED = RobotMap.SHOOTING_SPEED;
    private static final double INTAKE_SPEED = RobotMap.INTAKE_SPEED;

    public Shooter() {
        leftMotors = new PIDControllableMotor(RobotMap.LEFT_SHOOTER_TALON_IDS, RobotMap.LEFT_SHOOTER_ENCODER_ID, RobotMap.SHOOTER_PID_CONSTANTS);
        rightMotors = new PIDControllableMotor(RobotMap.RIGHT_SHOOTER_TALON_IDS, RobotMap.RIGHT_SHOOTER_ENCODER_ID, RobotMap.SHOOTER_PID_CONSTANTS);

        leftMotors.resetEncoder();
        rightMotors.resetEncoder();
    }

    public void shoot() {
        leftMotors.setSpeedPID(SHOOTING_SPEED);
        rightMotors.setSpeedPID(-SHOOTING_SPEED);
    }

    public void intake() {
        leftMotors.setSpeedPID(-INTAKE_SPEED);
        rightMotors.setSpeedPID(INTAKE_SPEED);
    }

    public void stop() {
        leftMotors.stop();
        rightMotors.stop();
    }

    @Override
    protected void initDefaultCommand() {

    }

}