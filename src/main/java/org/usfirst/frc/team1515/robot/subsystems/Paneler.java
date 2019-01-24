package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.util.Piston;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Paneler extends Subsystem {

    private Piston piston;

    public Paneler(Pair<Integer> solenoidPorts) {
        piston = new Piston(solenoidPorts);
    }

    public void extend() {
       piston.open();
    }

    public void retract() {
        piston.close();
    }

    public void toggle() {
        piston.toggle();
    }

    @Override
    protected void initDefaultCommand() {

    }

}