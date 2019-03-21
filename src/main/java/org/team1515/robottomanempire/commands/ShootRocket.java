package org.team1515.robottomanempire.commands;

import org.team1515.robottomanempire.Controls;
import org.team1515.robottomanempire.Robot;
import org.team1515.robottomanempire.RobotMap;
import org.team1515.robottomanempire.commands.arm.SetArmAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootRocket extends CommandGroup {

    public ShootRocket() {
        double slider = Robot.manipStick.getRawAxis(Controls.SHOOT_ROCKET_AXIS);
        if (slider == 0) {
            low();
        } else if (slider == 1) {
            high();
        } else {
            mid();
        }
    }

    private void low() {
        // addParallel(new DriveBackward(RobotMap.LOW_ROCKET_DIST));;
        addSequential(new SetArmAngle(RobotMap.LOW_ROCKET_ANGLE));
        // addSequential(new Shoot(3));
    }

    private void mid() {
        // addParallel(new DriveBackward(RobotMap.MID_ROCKET_DIST));
        addSequential(new SetArmAngle(RobotMap.MID_ROCKET_ANGLE));
        // addSequential(new Shoot(3));
    }

    private void high() {
        // addParallel(new DriveBackward(RobotMap.HIGH_ROCKET_DIST));
        addSequential(new SetArmAngle(RobotMap.HIGH_ROCKET_ANGLE));
        // addSequential(new Shoot(3));
    }

}