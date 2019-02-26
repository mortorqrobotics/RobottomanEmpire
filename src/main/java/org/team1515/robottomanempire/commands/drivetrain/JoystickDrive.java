package org.team1515.robottomanempire.commands.drivetrain;

import org.team1515.robottomanempire.Robot;

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