package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReduceSpeed extends Command {

    public ReduceSpeed() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void execute() {
        Robot.driveTrain.reduceSpeed();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}