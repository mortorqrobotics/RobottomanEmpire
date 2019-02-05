package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerArm extends Command {

    public LowerArm() {
        requires(Robot.arm);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.arm.lower();
    }

    @Override
    protected void end() {
        Robot.arm.stop();
    }
 
}