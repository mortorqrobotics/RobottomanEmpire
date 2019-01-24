package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.util.AbsoluteEncoder;
import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private MotorModule intakeMotors;
    private MotorModule shootingMotors;
    private MotorModule elevationMotors;

    private AbsoluteEncoder elevationEncoder;

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

    @Override
    protected void initDefaultCommand() {

    }

}