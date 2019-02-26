package org.team1515.robottomanempire.commands.drivetrain;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBackward extends Command {

    private double target;
    private double initial;

    private static final double SPEED = 0.3;

    public DriveBackward(double midRocketAngle) {
        requires(Robot.driveTrain);
        this.target = midRocketAngle;
        this.initial = Robot.driveTrain.getPosition();
    }

    @Override
    protected void execute() {
        Robot.driveTrain.setSpeed(-SPEED);
    }

	@Override
	protected boolean isFinished() {
		return Math.abs(initial - Robot.driveTrain.getPosition()) > target;
	}

}