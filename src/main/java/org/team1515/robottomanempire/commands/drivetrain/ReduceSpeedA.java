package org.team1515.robottomanempire.commands.drivetrain;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReduceSpeedA extends Command {

    public ReduceSpeedA() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void execute() {
        Robot.driveTrain.reduceSpeedA();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}