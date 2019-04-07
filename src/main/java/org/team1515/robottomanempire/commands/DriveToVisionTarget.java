package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;
import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToVisionTarget extends Command {

    private boolean isTargetDetected;
    private double horizontalOffset;
    private double area;

    private double forward;
    private double twist;

    private static final double TARGET_AREA = 20;
    private static final double THRESHOLD = 2;

    private static final double FORWARD = 0.3;
    private static final double TWIST = 0.3;

    public DriveToVisionTarget() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.driveTrain.setDefaultDirection();
        Robot.driveStick.setRumble(RumbleType.kRightRumble, RobotMap.SOFT_RUMBLE);
    }

    @Override
    protected void execute() {
        isTargetDetected = Robot.limelight.isTargetDetected();
        horizontalOffset = Robot.limelight.getHorizontalOffset();
        area = Robot.limelight.getArea();
        if (isTargetDetected) {
            forward = FORWARD * (TARGET_AREA - area);
            twist = TWIST * horizontalOffset;
            Robot.driveTrain.drive(forward, twist);
        }
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(TARGET_AREA - area) < THRESHOLD;
    }

    @Override
    protected void end() {
        Robot.driveStick.setRumble(RumbleType.kRightRumble, 0);
    }

}