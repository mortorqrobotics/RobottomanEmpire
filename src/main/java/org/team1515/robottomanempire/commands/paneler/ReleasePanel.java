package org.team1515.robottomanempire.commands.paneler;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReleasePanel extends Command {

	public ReleasePanel() {
		requires(Robot.paneler);
	}

	@Override
	protected void initialize() {
		Robot.paneler.release();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
