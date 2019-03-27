package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Controls;
import org.team1515.robottomanempire.Robot;
import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.commands.arm.SetArmAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootRocket extends CommandGroup {

	public ShootRocket() {
		double slider = Robot.manipStick.getRawAxis(Controls.SHOOT_ROCKET_AXIS);
		if (slider == 0) {
			low();
		} else if (slider == 1) {
			high();
		} else {
			mid();
		}
	}

	private void low() {
		addSequential(new SetArmAngle(RobotMap.LOW_ROCKET_ANGLE));
	}

	private void mid() {
		addSequential(new SetArmAngle(RobotMap.MID_ROCKET_ANGLE));
	}

	private void high() {
		addSequential(new SetArmAngle(RobotMap.HIGH_ROCKET_ANGLE));
	}

}
