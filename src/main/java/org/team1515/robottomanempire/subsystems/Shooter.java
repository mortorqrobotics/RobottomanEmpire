package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.subsystems.encoders.ShooterEncoder;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    public PIDControllableMotor topMotor;
    private PIDControllableMotor bottomMotor;

    private static final double SHOOTING_SPEED = RobotMap.SHOOTING_SPEED;
    private static final double INTAKE_SPEED = RobotMap.INTAKE_SPEED;

    public Shooter() {
        topMotor = new PIDControllableMotor(RobotMap.TOP_SHOOTER_TALON_IDS,  RobotMap.TOP_SHOOTER_PID_CONSTANTS, new ShooterEncoder(RobotMap.TOP_SHOOTER_ENCODER_ID));
        bottomMotor = new PIDControllableMotor(RobotMap.BOTTOM_SHOOTER_TALON_IDS, RobotMap.BOTTOM_SHOOTER_PID_CONSTANTS, new ShooterEncoder(RobotMap.BOTTOM_SHOOTER_ENCODER_ID));

        bottomMotor.resetEncoder();
        topMotor.resetEncoder();
    }

    public void shoot() {
        topMotor.setSpeed(SHOOTING_SPEED);
        bottomMotor.setSpeed(SHOOTING_SPEED);
    }

    public void intake() {
        topMotor.setSpeedPID(-INTAKE_SPEED);
        bottomMotor.setSpeedPID(-INTAKE_SPEED);
    }

    public void stop() {
        topMotor.stop();
        bottomMotor.stop();
    }

    public void printPID() {
        topMotor.print("top shooter");
        bottomMotor.print("bottom shooter");
    }

    @Override
    protected void initDefaultCommand() {

    }

}