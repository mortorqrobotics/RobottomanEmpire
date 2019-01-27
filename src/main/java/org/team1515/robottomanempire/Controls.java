package org.team1515.robottomanempire;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controls {
	
	public static final int DRIVE_STICK = 2;
	public static final int MANIPULATOR_STICK = 3;
	
	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;
	
	public static final int THROTTLE = 2;
	
	public static final int TWIST = 5;
	public static final int TURN_SPEED = 2;

	public static final Button TOGGLE_PANELER = new JoystickButton(Robot.driveStick, 1);

}