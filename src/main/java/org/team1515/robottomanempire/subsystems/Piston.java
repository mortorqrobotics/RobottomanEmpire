package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.util.Pair;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Piston {

	private DoubleSolenoid solenoid;
	private boolean isOpen;

    public Piston(Pair<Integer> solenoidPorts) {
        solenoid = new DoubleSolenoid(RobotMap.PCM_ID, solenoidPorts.first, solenoidPorts.last);
        isOpen = false;
    }

    public void open() {
		solenoid.set(Value.kForward);
		isOpen = true;
	}

	public void close() {
		solenoid.set(Value.kReverse);
		isOpen = false;
	}
	
	public void toggle() {
		if (isOpen) {
			close();
		} else {
			open();
		}
	}

    public boolean isOpen() {
        return isOpen;
    }

}