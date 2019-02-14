package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoldPaneler extends Command {

    public HoldPaneler() {
        requires(Robot.paneler);
    }

    @Override
    protected void initialize() {
        Robot.paneler.eject();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end(){
        Robot.paneler.grab();
    }

}