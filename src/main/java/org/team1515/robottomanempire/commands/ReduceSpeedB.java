package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReduceSpeedB extends Command {

    public ReduceSpeedB() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void execute() {
        Robot.driveTrain.reduceSpeedB();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}