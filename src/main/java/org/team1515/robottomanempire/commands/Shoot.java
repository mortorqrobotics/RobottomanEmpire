package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
    
    public Shoot() {
        requires(Robot.shooter);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.shooter.shoot();
    }

    @Override
    protected void end() {
        Robot.shooter.stop();
    }

}