package org.team1515.robottomanempire;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controls {
	
	public static final int DRIVE_STICK = 0;
	public static final int MANIPULATOR_STICK = 1;
	
	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;

	public static final JoystickButton REVERSE_DRIVETRAIN = new JoystickButton(Robot.driveStick, 1);
	public static final JoystickButton REDUCE_SPEED_A = new JoystickButton(Robot.driveStick, 5);
	public static final JoystickButton REDUCE_SPEED_B = new JoystickButton(Robot.driveStick, 6);
	
	public static final Button TOGGLE_PANELER = new JoystickButton(Robot.manipStick, -1);
	public static final Button RELEASE_PANEL = new JoystickButton(Robot.manipStick, 1);

	public static final Button SLIDE_PANELER_FORWARD = new JoystickButton(Robot.manipStick, 5);
	public static final Button SLIDE_PANELER_BACKWARD = new JoystickButton(Robot.manipStick, 3);

	public static final Button RAISE_ARM = new JoystickButton(Robot.manipStick, 6);
	public static final Button LOWER_ARM = new JoystickButton(Robot.manipStick, 4);

	public static final Button SHOOT = new JoystickButton(Robot.driveStick, 2);
	public static final Button INTAKE = new JoystickButton(Robot.driveStick, 3);

	public static final Button LIFT = new JoystickButton(Robot.manipStick, 11);
	public static final Button DRIVE_CLIMBER = new JoystickButton(Robot.manipStick, 9);
	public static final Button RETRACT_BACK_CLIMBER = new JoystickButton(Robot.manipStick, 12);
	public static final Button RETRACT_FRONT_CLIMBER = new JoystickButton(Robot.manipStick, 10);
	public static final Button UNLIFT = new JoystickButton(Robot.manipStick, 7);

}