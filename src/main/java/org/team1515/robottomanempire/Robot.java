/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team1515.robottomanempire;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.team1515.robottomanempire.commands.climber.Unlift;
import org.team1515.robottomanempire.subsystems.Arm;
import org.team1515.robottomanempire.subsystems.Climber;
import org.team1515.robottomanempire.subsystems.DriveTrain;
import org.team1515.robottomanempire.subsystems.Paneler;
import org.team1515.robottomanempire.subsystems.Shooter;
import org.team1515.robottomanempire.util.Limelight;

public class Robot extends TimedRobot {

	public static DriveTrain driveTrain;
	public static Paneler paneler;
	public static Shooter shooter;
	public static Arm arm;
	public static Climber climber;

	public static Joystick driveStick;
	public static Joystick throttleStick;
	public static Joystick manipStick;

	public static UsbCamera camera;
	public static Limelight limelight;

	public static OI oi;
	public static Timer timer;

	@Override
	public void robotInit() {
		driveTrain = new DriveTrain();
		paneler = new Paneler();
		shooter = new Shooter();
		arm = new Arm();
		climber = new Climber();

		driveStick = new Joystick(Controls.DRIVE_STICK);
		manipStick = new Joystick(Controls.MANIPULATOR_STICK);

		camera = CameraServer.getInstance().startAutomaticCapture();
		limelight = new Limelight();

		oi = new OI();
		timer = new Timer();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("abs encoder", arm.getAngle());
	}

	@Override
	public void autonomousInit() {
		limelight.setLedMode(3)
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		limelight.setLedMode(3)
		timer.start();
		new Unlift().start();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		// double timeInterval = timer.get() % RobotMap.RUMBLE_INTERVAL;
		// if (timeInterval > 0 && timeInterval < 1) {
		// 	driveStick.setRumble(RumbleType.kRightRumble, 1);
		// 	driveStick.setRumble(RumbleType.kLeftRumble, 1);
		// } else {
		// 	driveStick.setRumble(RumbleType.kRightRumble, 0);
		// 	driveStick.setRumble(RumbleType.kLeftRumble, 0);
		// }
		if (limelight.isTargetDetected()) {
			driveStick.setRumble(RumbleType.kLeftRumble, RobotMap.SOFT_RUMBLE);
		} else {
			driveStick.setRumble(RumbleType.kLeftRumble, 0);
		}
	}

	@Override
	public void testPeriodic() {

	}

}
