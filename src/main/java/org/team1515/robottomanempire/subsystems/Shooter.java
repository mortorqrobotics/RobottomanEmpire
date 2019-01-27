package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.util.AbsoluteEncoder;
import org.team1515.robottomanempire.util.MotorModule;
import org.team1515.robottomanempire.util.Pair;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private MotorModule intakeMotors;
    private MotorModule shootingMotors;
    private MotorModule elevationMotors;

    private AbsoluteEncoder elevationEncoder;
    private Encoder integratedEncoder;

    private static final double ELEVATION_SPEED = 0.5;
    private static final double SHOOTING_SPEED = 0.3;

    public Shooter(int[] intakeTalonIds, int[] shootingTalonIds, int[] elevationTalonIds,
            int elevationEncoderPort, Pair<Double> elevationEncoderMinMax) {
        intakeMotors = new MotorModule(intakeTalonIds);
        shootingMotors = new MotorModule(shootingTalonIds);
        elevationMotors = new MotorModule(elevationTalonIds);

        elevationEncoder = new AbsoluteEncoder(elevationEncoderPort, elevationEncoderMinMax);
    }

    public double getAngle() {
        return elevationEncoder.getAngle();
    }

    public void elevate() {
        elevationMotors.setSpeed(ELEVATION_SPEED);
    }

    public void shoot() {
        shootingMotors.setSpeed(SHOOTING_SPEED);
    }

    @Override
    protected void initDefaultCommand() {

    }

}