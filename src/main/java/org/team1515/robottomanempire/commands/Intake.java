package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {
    
    public Intake() {
        requires(Robot.shooter);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.shooter.intake();
    }

    @Override
    protected void end() {
        Robot.shooter.stop();
    }

}