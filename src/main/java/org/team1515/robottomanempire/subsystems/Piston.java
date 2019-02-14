package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.util.Pair;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Piston {

	private DoubleSolenoid solenoid;
	private boolean isExtended;

    public Piston(Pair<Integer> solenoidPorts) {
        solenoid = new DoubleSolenoid(RobotMap.PCM_ID, solenoidPorts.first, solenoidPorts.last);
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