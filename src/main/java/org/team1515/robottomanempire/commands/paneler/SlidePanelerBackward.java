package org.team1515.robottomanempire.commands.paneler;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SlidePanelerBackward extends Command {

    public SlidePanelerBackward() {
       requires(Robot.paneler);
    }

    @Override
    protected void execute() {
        Robot.paneler.slideBackward();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}