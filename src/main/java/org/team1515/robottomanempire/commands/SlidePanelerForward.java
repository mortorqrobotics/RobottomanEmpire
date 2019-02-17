package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SlidePanelerForward extends Command{

    public SlidePanelerForward() {
        requires(Robot.paneler);
    }

    @Override
    protected void execute() {
        Robot.paneler.slideForward();
    }

	@Override
	protected boolean isFinished() {
		return true;
    }

}