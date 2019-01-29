/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team1515.robottomanempire;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.team1515.robottomanempire.subsystems.DriveTrain;
import org.team1515.robottomanempire.subsystems.Paneler;
import org.team1515.robottomanempire.subsystems.Shooter;
import org.team1515.robottomanempire.RobotMap;

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
	public static Joystick driveStick;
	public static Joystick manipStick;

	public static OI oi;

	@Override
	public void robotInit() {
		driveTrain = new DriveTrain(RobotMap.LEFT_DRIVE_TALONS, RobotMap.RIGHT_DRIVE_TALONS, RobotMap.RIGHT_DRIVE_ENCODER, RobotMap.LEFT_DRIVE_ENCODER);
		driveStick = new Joystick(Controls.DRIVE_STICK);
		manipStick = new Joystick(Controls.MANIPULATOR_STICK);
		paneler = new Paneler(RobotMap.PANELER_SOLENOID);
		shooter = new Shooter(RobotMap.SHOOTING_TALONS, RobotMap.ARM_TALONS, RobotMap.ARM_ENCODER, RobotMap.ARM_ENCODER_MIN_MAX);

		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();
		oi = new OI();
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

	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		shooter.elevate();
	}

	@Override
	public void testPeriodic() {
	}
}
