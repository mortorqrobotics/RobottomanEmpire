package org.team1515.robottomanempire.commands.arm;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetArmAngle extends Command {

    private double target;

    private static final double THRESHOLD = 5.0;
    private static final double TIMEOUT = 100; 

    public SetArmAngle(double target) {
        this.target = target;
        setTimeout(TIMEOUT);
        requires(Robot.arm);
    }

    @Override
    protected void execute() {
        Robot.arm.setAngle(target);
        Robot.arm.printPID();
    }

    @Override
    protected boolean isFinished() {
        // double actual = Robot.arm.getAngle();
        // boolean isWithinThreshold = Math.abs(target - actual) <= THRESHOLD;
        // return isWithinThreshold || isTimedOut();
        return false;
    }

    @Override
    protected void end() {
        Robot.arm.hold();
    }

}