package org.team1515.robottomanempire.commands.climber;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RetractBackClimber extends Command {

    public RetractBackClimber() {
        requires(Robot.climber);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void execute() {
        Robot.climber.retractBack();
    }
}