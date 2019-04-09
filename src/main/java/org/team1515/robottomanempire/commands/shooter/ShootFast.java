package org.team1515.robottomanempire.commands.shooter;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootFast extends Command {

	public ShootFast() {
		requires(Robot.shooter);
	}

	public ShootFast(double timeout) {
		requires(Robot.shooter);
		setTimeout(timeout);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void execute() {
		Robot.shooter.shootFast();
		Robot.timer.delay(0.25);
		Robot.shooter.push();
	}

	@Override
	protected void end() {
		Robot.shooter.stop();
		Robot.paneler.grab();
	}

}
