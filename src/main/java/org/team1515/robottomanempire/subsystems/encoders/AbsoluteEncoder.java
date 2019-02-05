package org.team1515.robottomanempire.subsystems.encoders;

import org.team1515.robottomanempire.util.Pair;

import edu.wpi.first.wpilibj.AnalogInput;

public class AbsoluteEncoder implements GenericEncoder {

    private AnalogInput encoder;
    private double voltageMin;
    private double voltageMax;

    public AbsoluteEncoder(int port, Pair<Double> voltageMinMax) {
        encoder = new AnalogInput(port);
        this.voltageMin = voltageMinMax.first;
        this.voltageMax = voltageMinMax.last;
    }

    public void reset() {
        encoder.resetAccumulator();
    }

    // angle in degrees
    @Override
    public double get() {
        return 360 * (encoder.getVoltage() - voltageMin) / (voltageMax - voltageMin);
    }

}