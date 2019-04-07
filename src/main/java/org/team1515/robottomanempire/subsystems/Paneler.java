package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.subsystems.Piston;
import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Paneler extends Subsystem {

	private DoublePiston piston;
	private Piston sliders;

	public Paneler() {
		piston = new DoublePiston(RobotMap.PANELER_SOLENOID_ID);
		sliders = new Piston(RobotMap.SLIDER_SOLENOID_ID);
	}

	public void release() {
		piston.retract();
	}

	public void grab() {
		piston.extend();
	}

	public void slideForward() {
		sliders.extend();
	}

	public void slideBackward() {
		sliders.retract();
	}

	public void toggleSliders() {
		sliders.toggle();
	}

	public void toggle() {
		piston.toggle();
	}

	@Override
	protected void initDefaultCommand() {

	}

}
