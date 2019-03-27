package org.team1515.robottomanempire.commands.paneler;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GrabPanel extends Command {

	public GrabPanel() {
		requires(Robot.paneler);
	}

	@Override
	public synchronized void start() {
		Robot.paneler.grab();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
