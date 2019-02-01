package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.util.AbsoluteEncoder;
import org.team1515.robottomanempire.util.MotorModule;
import org.team1515.robottomanempire.util.PIDController;
import org.team1515.robottomanempire.util.Pair;
import org.team1515.robottomanempire.util.Triple;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    public MotorModule shooterMotors;
    private MotorModule armMotors;

    private AbsoluteEncoder armEncoder;
    private Encoder shooterEncoder;
    private PIDController armPIDController;
    private PIDController shooterPIDController;

    private static final double ARM_SPEED = 1;
    private static final double SHOOTING_SPEED = 0.5;

    private static final Triple<Double> ARM_PID_CONSTANTS = new Triple<Double>(1.0, 0.0, 0.0);
    private static final Triple<Double> SHOOTER_PID_CONSTANTS = new Triple<Double>(0.4, 0.1, 0.0);

    public Shooter(int[] shootingTalonIds, int[] armTalonIds,
            int armEncoderPort, Pair<Integer> shooterEncoderPorts) {
        shooterMotors = new MotorModule(shootingTalonIds);
        armMotors = new MotorModule(armTalonIds);

        armEncoder = new AbsoluteEncoder(armEncoderPort, RobotMap.ARM_ENCODER_MIN_MAX);
        armEncoder.reset();
        shooterEncoder = new Encoder(shooterEncoderPorts.first, shooterEncoderPorts.last);
        shooterEncoder.reset();
        shooterEncoder.setReverseDirection(true);
        
        armPIDController = new PIDController(ARM_PID_CONSTANTS.first, ARM_PID_CONSTANTS.second, ARM_PID_CONSTANTS.third);
        shooterPIDController = new PIDController(SHOOTER_PID_CONSTANTS.first, SHOOTER_PID_CONSTANTS.second, SHOOTER_PID_CONSTANTS.third);
    }

    public void raise() {
        armMotors.setSpeed(ARM_SPEED);
    }

    public void lower() {
        armMotors.setSpeed(-ARM_SPEED);
    }

    public void setAngle(double angle) {
        double output = armPIDController.getOutput(angle, armEncoder.getAngle());
        armMotors.setSpeed(output);
    }

    public double getAngle() {
        return armEncoder.getAngle();
    }

    public void shoot() {
        setSpeed(SHOOTING_SPEED);
    }

    public void intake() {
        setSpeed(-SHOOTING_SPEED);
    }

    public void setSpeed(double speed) {
        double output = shooterPIDController.getOutput(speed, getSpeed());
        shooterPIDController.printToSmartDashboard("shooter");
        shooterMotors.setSpeed(output);
    }

    public double getSpeed() {
        return shooterEncoder.getRate() / 1000;
    }

    @Override
    protected void initDefaultCommand() {

    }

}