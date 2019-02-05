package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

    private PIDControllableMotor motors;

    private static final double SPEED = RobotMap.ARM_SPEED;

    public Arm() {
        motors = new PIDControllableMotor(RobotMap.ARM_TALON_IDS, RobotMap.ARM_ENCODER_ID, RobotMap.ARM_ENCODER_MIN_MAX, RobotMap.ARM_PID_CONSTANTS);
        motors.resetEncoder();
    }

    public void raise() {
        motors.setSpeed(SPEED);
    }

    public void lower() {
        motors.setSpeed(-SPEED);
    }

    public void setAngle(double angle) {
        motors.setSpeedPID(angle);
    }

    public double getAngle() {
       return motors.getEncoderMeasurement(); 
    }

    public void stop() {
        motors.stop();
    }

    @Override
    protected void initDefaultCommand() {

    }

}