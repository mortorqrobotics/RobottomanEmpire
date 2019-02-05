package org.team1515.robottomanempire.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MotorModule {
	
	private TalonSRX[] talons;
	
	public MotorModule(int[] talonIds) {
		talons = new TalonSRX[talonIds.length];
		for (int i = 0; i < talonIds.length; i++) {
			talons[i] = new TalonSRX(talonIds[i]);
		}
	}

	public TalonSRX getTalonOfId(int id) {
		for (TalonSRX talon : talons) {
			if (talon.getDeviceID() == id) {
				return talon;
			}			
		}
		return null;
	}

	public void setSpeed(double speed) {
		for (TalonSRX talon : talons) {
			talon.set(ControlMode.PercentOutput, speed);
		}
	}
	
	public void stop() {
		for (TalonSRX talon : talons) {
			talon.set(ControlMode.PercentOutput, 0);
		}
	}

}