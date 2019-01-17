package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TogglePaneler extends Command {

    public TogglePaneler() {
        requires(Robot.paneler);
    }

    @Override
    protected void initialize() {
        Robot.paneler.togglePiston();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}