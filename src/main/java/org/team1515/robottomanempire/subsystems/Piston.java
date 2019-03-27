package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.util.Pair;

import edu.wpi.first.wpilibj.Solenoid;

public class Piston {

	private Solenoid solenoid;
	private boolean isExtended;

	public Piston(Pair<Integer> solenoidId) {
		solenoid = new Solenoid(solenoidId.first, solenoidId.last);
		isExtended = false;
	}

	public void extend() {
		solenoid.set(true);
		isExtended = true;
	}

	public void retract() {
		solenoid.set(false);
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
