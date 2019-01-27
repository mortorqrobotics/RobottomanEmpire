/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1515.robot;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

import org.usfirst.frc.team1515.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1515.robot.subsystems.Paneler;
import org.usfirst.frc.team1515.robot.subsystems.Shooter;

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
		driveTrain = new DriveTrain(RobotMap.LEFT_TALON_IDS, RobotMap.RIGHT_TALON_IDS, RobotMap.RIGHT_ENCODER_PORTS, RobotMap.LEFT_ENCODER_PORTS);
		driveStick = new Joystick(Controls.DRIVE_STICK);
		manipStick = new Joystick(Controls.MANIPULATOR_STICK);
		paneler = new Paneler(RobotMap.PANELER_SOLENOID_PORTS);
		shooter = new Shooter(RobotMap.INTAKE_TALON_IDS, RobotMap.SHOOTING_TALON_IDS, RobotMap.ELEVATION_TALON_IDS, RobotMap.ELEVATION_ENCODER_PORT, RobotMap.ELEVATION_ENCODER_MIN_MAX);

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
		System.out.println(shooter.getAngle());
	}

	@Override
	public void testPeriodic() {
	}
}
