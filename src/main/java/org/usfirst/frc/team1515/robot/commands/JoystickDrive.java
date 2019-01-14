package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoystickDrive extends Command {

    public JoystickDrive() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void execute() {
        Robot.driveTrain.drive();    
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}