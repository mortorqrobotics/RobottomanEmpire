package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {

    public Climb() {
        requires(Robot.climber);
    }

    @Override
    protected void execute() {
        Robot.climber.climb();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}