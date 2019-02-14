package org.team1515.robottomanempire;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controls {
	
	public static final int DRIVE_STICK = 2;
	public static final int THROTTLE_STICK = 0;
	public static final int MANIPULATOR_STICK = 1;
	
	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;
	public static final int THROTTLE_AXIS = 2;
	public static final int TURNSPEED_AXIS = 6;
	
	public static final Button TOGGLE_PANELER = new JoystickButton(Robot.manipStick, -1);
	public static final Button GRAB_PANEL = new JoystickButton(Robot.manipStick, 1);

	public static final Button RAISE_ARM = new JoystickButton(Robot.driveStick, 1);
	public static final Button LOWER_ARM = new JoystickButton(Robot.driveStick, 4);

	public static final Button SHOOT = new JoystickButton(Robot.driveStick, 2);
	public static final Button INTAKE = new JoystickButton(Robot.driveStick, 3);

}