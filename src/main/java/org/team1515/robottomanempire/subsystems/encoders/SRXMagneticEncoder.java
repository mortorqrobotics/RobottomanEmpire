package org.team1515.robottomanempire.subsystems.encoders;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class SRXMagneticEncoder implements GenericEncoder {
    
    private TalonSRX talon;

    public SRXMagneticEncoder(TalonSRX talon) {
        this.talon = talon;
    }

    @Override
    public double get() {
        return talon.getSelectedSensorVelocity();
    }

    @Override
    public void reset() {
        talon.setSelectedSensorPosition(0);
    }

}