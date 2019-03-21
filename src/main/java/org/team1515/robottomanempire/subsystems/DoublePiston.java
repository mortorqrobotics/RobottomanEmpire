package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.util.Triple;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DoublePiston {

	private DoubleSolenoid solenoid;
	private boolean isExtended;

    public DoublePiston(Triple<Integer> sliderSolenoidId) {
        solenoid = new DoubleSolenoid(sliderSolenoidId.first, sliderSolenoidId.second, sliderSolenoidId.last);
        isExtended = false;
	}

    public void extend() {
		solenoid.set(Value.kForward);
		isExtended = true;
	}

	public void retract() {
		solenoid.set(Value.kReverse);
		isExtended = false;
	}
	
	public void toggle() {
		if (isExtended) {
			retract();
		} else {
			extend();
		}
	}

    public boolean isOpen() {
        return isExtended;
    }

}