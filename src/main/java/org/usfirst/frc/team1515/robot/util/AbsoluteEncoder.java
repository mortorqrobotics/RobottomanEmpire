package org.usfirst.frc.team1515.robot.util;

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

    // degrees
    public double getAngle() {
        return 360 * (encoder.getVoltage() - voltageMin) / (voltageMax - voltageMin);
    }

}