package org.team1515.robottomanempire.subsystems.encoders;

import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.util.Pair;

import edu.wpi.first.wpilibj.Encoder;

public class ShooterEncoder implements GenericEncoder {

    private Encoder encoder;

    private static final double WHEEL_DIAMETER = RobotMap.SHOOTER_WHEEL_DIAMETER;
    private static final int TICKS_PER_REV = RobotMap.SHOOTER_ENCODER_TICKS_PER_REV;

    public ShooterEncoder(Pair<Integer> ids) {
        encoder = new Encoder(ids.first, ids.last);
    }

    @Override
    public double get() {
        double circumference = Math.PI * WHEEL_DIAMETER;
        return encoder.getRate() * circumference / TICKS_PER_REV;
    }

    @Override
    public void reset() {
        encoder.reset();
    }

}