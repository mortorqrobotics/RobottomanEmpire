package org.team1515.robottomanempire.subsystems.encoders;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.team1515.robottomanempire.RobotMap;

public class SRXMagneticEncoder implements GenericEncoder {

	private TalonSRX talon;

	private static final double TICKS_PER_REV = RobotMap.DRIVE_ENCODER_TICKS_PER_REV;
	private static final double WHEEL_DIAMETER = RobotMap.DRIVE_WHEEL_DIAMETER;

	public SRXMagneticEncoder(TalonSRX talon) {
		this.talon = talon;
	}

	@Override
	public double get() {
		return talon.getSelectedSensorPosition() * WHEEL_DIAMETER  * Math.PI / TICKS_PER_REV;
	}

	@Override
	public void reset() {
		talon.setSelectedSensorPosition(0);
	}

}
