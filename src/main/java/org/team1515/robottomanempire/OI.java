/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team1515.robottomanempire;

import org.team1515.robottomanempire.commands.Climb;
import org.team1515.robottomanempire.commands.GrabPanel;
import org.team1515.robottomanempire.commands.Intake;
import org.team1515.robottomanempire.commands.LowerArm;
import org.team1515.robottomanempire.commands.RaiseArm;
import org.team1515.robottomanempire.commands.ReduceSpeed;
import org.team1515.robottomanempire.commands.ReleasePanel;
import org.team1515.robottomanempire.commands.ReverseDrivetrain;
import org.team1515.robottomanempire.commands.Shoot;
import org.team1515.robottomanempire.commands.SlidePanelerBackward;
import org.team1515.robottomanempire.commands.SlidePanelerForward;
import org.team1515.robottomanempire.commands.TogglePaneler;
import org.team1515.robottomanempire.commands.UnReduceSpeed;
import org.team1515.robottomanempire.Controls;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public OI() {
        Controls.TOGGLE_PANELER.whenPressed(new TogglePaneler());

        Controls.RELEASE_PANEL.whenPressed(new ReleasePanel());
        Controls.RELEASE_PANEL.whenReleased(new GrabPanel());

        Controls.SLIDE_PANELER_FORWARD.whenPressed(new SlidePanelerForward());
        Controls.SLIDE_PANELER_BACKWARD.whenPressed(new SlidePanelerBackward());

        Controls.RAISE_ARM.whileHeld(new RaiseArm());
        Controls.LOWER_ARM.whileHeld(new LowerArm());

        Controls.SHOOT.whileHeld(new Shoot());
        Controls.INTAKE.whileHeld(new Intake());

        Controls.REVERSE_DRIVETRAIN.whenPressed(new ReverseDrivetrain());

        Controls.REDUCE_SPEED.whenPressed(new ReduceSpeed());
        Controls.REDUCE_SPEED.whenReleased(new UnReduceSpeed());

        Controls.CLIMB.whenPressed(new Climb());
    }
}
