package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

    private Piston frontPiston;

    public Climber() {
        frontPiston = new Piston(RobotMap.FRONT_CLIMBER_SOLENOID_ID);
    }

    public void climb() {
        frontPiston.toggle();
    }

    @Override
    protected void initDefaultCommand() {

    }

}