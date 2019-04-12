package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Robot;
import org.team1515.robottomanempire.util.PIDController;
import org.team1515.robottomanempire.util.Triple;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToVisionTarget extends Command {

    private boolean isTargetDetected;
    private double horizontalOffset;
    private double area;

    private double forward;
    private double twist;

    private int counter = 0;
    private static final int COUNTER = 5;

    private static final double TARGET_AREA = 3.5;
    private static final double THRESHOLD_FORWARD = 0.1;
    private static final double THRESHOLD_TWIST = 1;

    private static final double FORWARD = 1;
    private static final Triple<Double> TWIST = new Triple<Double>(0.05, 0.0, 0.1);;

    private PIDController twistPIDController;

    public DriveToVisionTarget() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.driveTrain.setDefaultDirection();
        Robot.paneler.slideBackward();
        twistPIDController = new PIDController(TWIST);
    }

    @Override
    protected void execute() {
        isTargetDetected = Robot.limelight.isTargetDetected();
        horizontalOffset = Robot.limelight.getHorizontalOffset();
        area = Robot.limelight.getArea();
        if (isTargetDetected) {
            forward = FORWARD * (TARGET_AREA - area) / TARGET_AREA;
            twist = twistPIDController.getOutput(0, -horizontalOffset);
            Robot.driveTrain.drive(-forward, -twist);
        }
    }

    @Override
    protected boolean isFinished() {
        if (Math.abs(TARGET_AREA - area) < THRESHOLD_FORWARD && horizontalOffset < THRESHOLD_TWIST) {
            counter++;
        } else {
            counter = 0;
        }
        return counter >= COUNTER;
    }

    @Override
    protected void end() {
        Robot.driveTrain.stop();
        Robot.paneler.slideForward();
    }

}