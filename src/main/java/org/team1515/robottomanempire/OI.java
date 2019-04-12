/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team1515.robottomanempire;

import org.team1515.robottomanempire.commands.paneler.GrabPanel;
import org.team1515.robottomanempire.commands.shooter.Intake;
import org.team1515.robottomanempire.commands.climber.LiftBackClimber;
import org.team1515.robottomanempire.commands.climber.LiftFrontClimber;
import org.team1515.robottomanempire.commands.DriveToVisionTarget;
import org.team1515.robottomanempire.commands.ShootRocket;
import org.team1515.robottomanempire.commands.arm.LowerArm;
import org.team1515.robottomanempire.commands.arm.RaiseArm;
import org.team1515.robottomanempire.commands.drivetrain.JoystickDrive;
import org.team1515.robottomanempire.commands.drivetrain.ReduceSpeedA;
import org.team1515.robottomanempire.commands.drivetrain.ReduceSpeedB;
import org.team1515.robottomanempire.commands.paneler.ReleasePanel;
import org.team1515.robottomanempire.commands.climber.RetractBackClimber;
import org.team1515.robottomanempire.commands.climber.RetractFrontClimber;
import org.team1515.robottomanempire.commands.drivetrain.ReverseDrivetrain;
import org.team1515.robottomanempire.commands.shooter.Shoot;
import org.team1515.robottomanempire.commands.shooter.ShootFast;
import org.team1515.robottomanempire.commands.paneler.SlidePanelerBackward;
import org.team1515.robottomanempire.commands.paneler.SlidePanelerForward;
import org.team1515.robottomanempire.commands.drivetrain.UnReduceSpeed;
import org.team1515.robottomanempire.Controls;

public class OI {

	public OI() {

		Controls.RELEASE_PANEL.whenPressed(new ReleasePanel());
		Controls.RELEASE_PANEL.whenReleased(new GrabPanel());

		Controls.SLIDE_PANELER_FORWARD.whenPressed(new SlidePanelerForward());
		Controls.SLIDE_PANELER_BACKWARD.whenPressed(new SlidePanelerBackward());

		Controls.RAISE_ARM.whileHeld(new RaiseArm());
		Controls.LOWER_ARM.whileHeld(new LowerArm());

		Controls.SHOOT.whileHeld(new Shoot());
		Controls.SHOOT_FAST.whileHeld(new ShootFast());
		Controls.INTAKE.whileHeld(new Intake());

		Controls.REVERSE_DRIVETRAIN.whenPressed(new ReverseDrivetrain());

		Controls.REDUCE_SPEED_A.whenPressed(new ReduceSpeedA());
		Controls.REDUCE_SPEED_A.whenReleased(new UnReduceSpeed());

		Controls.REDUCE_SPEED_B.whenPressed(new ReduceSpeedB());
		Controls.REDUCE_SPEED_B.whenReleased(new UnReduceSpeed());

		Controls.LIFT_FRONT_CLIMBER.whenPressed(new LiftFrontClimber());
		Controls.LIFT_BACK_CLIMBER.whenPressed(new LiftBackClimber());
		Controls.RETRACT_FRONT_CLIMBER.whenPressed(new RetractFrontClimber());
		Controls.RETRACT_BACK_CLIMBER.whenPressed(new RetractBackClimber());

		Controls.SHOOT_ROCKET.whenPressed(new ShootRocket());

		Controls.DRIVE_TO_VISION_TARGET.whenPressed(new DriveToVisionTarget());
		Controls.DRIVE_TO_VISION_TARGET.whenReleased(new JoystickDrive());

	}
}
