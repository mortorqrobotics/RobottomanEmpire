package org.team1515.robottomanempire.commands.arm;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseArm extends Command {

    public RaiseArm() {
        requires(Robot.arm);
    }

    @Override
    protected boolean isFinished() {
        return Robot.arm.isAtMaxAngle();
    }

    @Override
    protected void execute() {
        Robot.arm.raise();
    }

    @Override
    protected void end() {
        if (Robot.arm.isAtMaxAngle()) {
            Robot.arm.stop();
        } else {
            Robot.arm.hold();
        }
    }
    
}