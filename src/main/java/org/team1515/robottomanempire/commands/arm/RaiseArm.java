package org.team1515.robottomanempire.commands.arm;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseArm extends Command {

	public RaiseArm() {
		requires(Robot.arm);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		Robot.arm.raise();
	}

	@Override
	protected void end() {
		Robot.arm.hold();
	}

}
