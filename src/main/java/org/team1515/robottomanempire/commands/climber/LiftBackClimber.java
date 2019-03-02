package org.team1515.robottomanempire.commands.climber;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftBackClimber extends Command {

    public LiftBackClimber() {
        requires(Robot.climber);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void execute() {
        Robot.climber.liftBack();
    }
}