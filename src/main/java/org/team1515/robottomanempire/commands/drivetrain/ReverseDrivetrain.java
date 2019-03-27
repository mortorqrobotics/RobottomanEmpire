package org.team1515.robottomanempire.commands.drivetrain;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReverseDrivetrain extends Command {

	public ReverseDrivetrain() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.reverse();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
