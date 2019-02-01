package org.team1515.robottomanempire.util;

import edu.wpi.first.wpilibj.AnalogInput;

public class AbsoluteEncoder {

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

    // degrees
    public double getAngle() {
        return 360 * (encoder.getVoltage() - voltageMin) / (voltageMax - voltageMin);
    }

}