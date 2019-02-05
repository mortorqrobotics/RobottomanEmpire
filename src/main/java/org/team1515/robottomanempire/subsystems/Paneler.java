package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.subsystems.Piston;
import org.team1515.robottomanempire.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Paneler extends Subsystem {

    private Piston piston;

    public Paneler() {
        piston = new Piston(RobotMap.PANELER_SOLENOID_ID);
    }

    public void eject() {
       piston.close();
    }

    public void retract() {
        piston.open();
    }

    public void toggle() {
        piston.toggle();
    }

    @Override
    protected void initDefaultCommand() {

    }

}