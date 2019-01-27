package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TogglePaneler extends Command {

    public TogglePaneler() {
        requires(Robot.paneler);
    }

    @Override
    protected void initialize() {
        Robot.paneler.toggle();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}