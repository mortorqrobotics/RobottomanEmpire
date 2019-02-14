package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {

    public PIDControllableMotor topMotor;
    private PIDControllableMotor bottomMotor;

    private static final double SHOOTING_SPEED = RobotMap.SHOOTING_SPEED;
    private static final double INTAKE_SPEED = RobotMap.INTAKE_SPEED;

    public Shooter() {
        topMotor = new PIDControllableMotor(RobotMap.RIGHT_SHOOTER_TALON_IDS, RobotMap.RIGHT_SHOOTER_ENCODER_ID, RobotMap.RIGHT_SHOOTER_PID_CONSTANTS);
        bottomMotor = new PIDControllableMotor(RobotMap.LEFT_SHOOTER_TALON_IDS, RobotMap.LEFT_SHOOTER_ENCODER_ID, RobotMap.LEFT_SHOOTER_PID_CONSTANTS);

        bottomMotor.resetEncoder();
        topMotor.resetEncoder();
    }

    public void shoot() {
        bottomMotor.setSpeed(SHOOTING_SPEED);
        topMotor.setSpeed(SHOOTING_SPEED);
    }

    public void intake() {
        bottomMotor.setSpeedPID(-INTAKE_SPEED);
        topMotor.setSpeedPID(-INTAKE_SPEED);
    }

    public void stop() {
        bottomMotor.stop();
        topMotor.stop();
    }

    public void printPID() {
        topMotor.print("top shooter");
        bottomMotor.print("bottom shooter");
        // SmartDashboard.putNumber("left", leftMotors.getEncoderMeasurement());
        // SmartDashboard.putNumber("right", rightMotors.getEncoderMeasurement());
    }

    @Override
    protected void initDefaultCommand() {

    }

}