package org.team1515.robottomanempire.commands.arm;

import org.team1515.robottomanempire.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveArm extends Command {

    public DriveArm() {
        requires(Robot.arm);
    }

    // cheesecake climber arm up and down
    @Override
    protected void execute() {
        SmartDashboard.putNumber("cheesecake", 1);
        Robot.arm.drive();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}