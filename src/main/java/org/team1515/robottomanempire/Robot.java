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
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.team1515.robottomanempire.subsystems.Arm;
import org.team1515.robottomanempire.subsystems.Climber;
import org.team1515.robottomanempire.subsystems.DriveTrain;
import org.team1515.robottomanempire.subsystems.Paneler;
import org.team1515.robottomanempire.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static DriveTrain driveTrain;
	public static Paneler paneler;
	public static Shooter shooter;
	public static Arm arm;
	public static Climber climber;

	public static Joystick driveStick;
	public static Joystick throttleStick;
	public static Joystick manipStick;

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

		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();
		oi = new OI();
		timer = new Timer();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		timer.start();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		double timeInterval = timer.get() % RobotMap.RUMBLE_INTERVAL;
		if (timeInterval > 0 && timeInterval < 1) {
			driveStick.setRumble(RumbleType.kRightRumble, 1);
			driveStick.setRumble(RumbleType.kLeftRumble, 1);
		} else {
			driveStick.setRumble(RumbleType.kRightRumble, 0);
			driveStick.setRumble(RumbleType.kLeftRumble, 0);
		}
		// Robot.shooter.printPID();
	}

	@Override
	public void testPeriodic() {
	}
}
