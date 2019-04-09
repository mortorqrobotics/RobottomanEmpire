package org.team1515.robottomanempire.commands.drivetrain;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class UnReduceSpeed extends Command {

	public UnReduceSpeed() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.unReduceSpeed();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
