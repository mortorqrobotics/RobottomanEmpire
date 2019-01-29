package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.util.AbsoluteEncoder;
import org.team1515.robottomanempire.util.MotorModule;
import org.team1515.robottomanempire.util.Pair;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private MotorModule shootingMotors;
    private MotorModule armMotors;

    private AbsoluteEncoder armEncoder;

    private static final double ARM_SPEED = 1;
    private static final double SHOOTING_SPEED = 0.3;

    public Shooter(int[] shootingTalonIds, int[] armTalonIds,
            int armEncoderPort, Pair<Double> armEncoderMinMax) {
        shootingMotors = new MotorModule(shootingTalonIds);
        armMotors = new MotorModule(armTalonIds);

        armEncoder = new AbsoluteEncoder(armEncoderPort, armEncoderMinMax);
    }

    public double getAngle() {
        return armEncoder.getAngle();
    }

    public void elevate() {
        armMotors.setSpeed(ARM_SPEED);
    }

    public void shoot() {
        shootingMotors.setSpeed(SHOOTING_SPEED);
    }

    @Override
    protected void initDefaultCommand() {

    }

}