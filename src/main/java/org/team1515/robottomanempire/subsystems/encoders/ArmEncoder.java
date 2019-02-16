package org.team1515.robottomanempire.subsystems.encoders;

import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;

public class ArmEncoder implements GenericEncoder {

    private AnalogInput encoder;

    private static final double VOLTAGE_MIN = RobotMap.ARM_ENCODER_MIN_MAX.first;
    private static final double VOLTAGE_MAX = RobotMap.ARM_ENCODER_MIN_MAX.last;

    public ArmEncoder(int port) {
        encoder = new AnalogInput(port);
    }

    public void reset() {
        encoder.resetAccumulator();
    }

    // angle in degrees
    @Override
    public double get() {
        return 360 * (encoder.getVoltage() - VOLTAGE_MIN) / (VOLTAGE_MAX - VOLTAGE_MIN);
    }

}