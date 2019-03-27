package org.team1515.robottomanempire.commands.shooter;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	public Shoot() {
		requires(Robot.shooter);
	}

	public Shoot(double timeout) {
		requires(Robot.shooter);
		setTimeout(timeout);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void execute() {
		Robot.shooter.shoot();
		Robot.timer.delay(0.25);
		Robot.shooter.push();
	}

	@Override
	protected void end() {
		Robot.shooter.stop();
		Robot.paneler.grab();
	}

}
