package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReleasePanel extends Command {

    public ReleasePanel() {
        requires(Robot.paneler);
    }

    @Override
    public synchronized void start() {
        Robot.paneler.eject();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}