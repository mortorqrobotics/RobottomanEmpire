package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveClimber extends Command {

    public DriveClimber() {
        requires(Robot.climber);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.climber.driveForward();
    }

    @Override
    protected void end() {
        Robot.climber.stop();
    }
    
}