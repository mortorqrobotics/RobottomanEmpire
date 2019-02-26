/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team1515.robottomanempire;

import org.team1515.robottomanempire.util.Pair;
import org.team1515.robottomanempire.util.Triple;

public class RobotMap {

	// IDENTIFICATIONS

	public static final int[] LEFT_DRIVE_TALON_IDS = {37, 39, 41};
	public static final int[] RIGHT_DRIVE_TALON_IDS = {36, 38, 40};

	public static final int LEFT_DRIVE_ENCODER_ID = 41;
	public static final int RIGHT_DRIVE_ENCODER_ID = 40; 

	public static final int DRIVE_ENCODER_TICKS_PER_REV = 1024;
	public static final double DRIVE_WHEEL_DIAMETER = 6.0;

	public static final int[] TOP_SHOOTER_TALON_IDS = {34};
	public static final int[] BOTTOM_SHOOTER_TALON_IDS = {32};

	public static final Pair<Integer> TOP_SHOOTER_ENCODER_ID = new Pair<Integer>(0, 1);
	public static final Pair<Integer> BOTTOM_SHOOTER_ENCODER_ID = new Pair<Integer>(2, 3);

	public static final boolean TOP_SHOOTER_ENCODER_REVERSED = true;
	public static final boolean BOTTOM_SHOOTER_ENCODER_REVERSED = false;

	public static final int SHOOTER_ENCODER_TICKS_PER_REV = 12;
	public static final double SHOOTER_WHEEL_DIAMETER = 4.0;

	public static final int[] ARM_TALON_IDS = {33};

	public static final int ARM_ENCODER_ID = 0;
	public static final Pair<Double> ARM_ENCODER_MIN_MAX = new Pair<Double>(0.01464, 4.814);

	public static final int[] CLIMBER_TALON_IDS = {35};

	public static final int SHOOTER_LIMIT_SWITCH_ID = 4;
	public static final int ARM_LIMIT_SWITCH_ID = 5;

	// PNEUMATICS

	public static final int PCM_A_ID = 11;
	public static final int PCM_B_ID = 12;
 
	public static final Triple<Integer> PANELER_SOLENOID_ID = new Triple<Integer>(PCM_A_ID, 0, 1);
	public static final Triple<Integer> SLIDER_SOLENOID_ID = new Triple<Integer>(PCM_A_ID, 2, 3);
	public static final Triple<Integer> SHOOTER_SOLENOID_ID = new Triple<Integer>(PCM_B_ID, 0, 1);
	public static final Triple<Integer> FRONT_CLIMBER_SOLENOID_ID = new Triple<Integer>(PCM_A_ID, 6, 7);
	public static final Triple<Integer> BACK_CLIMBER_SOLENOID_ID = new Triple<Integer>(PCM_A_ID, 4, 5);

	// SPEEDS

	public static final double SHOOTING_SPEED = 0.5;
	public static final double INTAKE_SPEED = 0.3;
	public static final double ARM_RAISE_SPEED = 0.4;
	public static final double ARM_LOWER_SPEED = 0.4;
	public static final double ARM_HOLD_SPEED = 0.2;
	public static final double CLIMBER_DRIVE_SPEED = -1.0;

	// PID CONSTANTS

	public static final Triple<Double> TOP_SHOOTER_PID_CONSTANTS = new Triple<Double>(1.0, 0.1, 0.0);
	public static final Triple<Double> BOTTOM_SHOOTER_PID_CONSTANTS = new Triple<Double>(1.0, 0.1, 0.0);
	public static final Triple<Double> ARM_PID_CONSTANTS = new Triple<Double>(0.005, 0.00005, 0.0);
    public static final Triple<Double> LEFT_DRIVE_PID_CONSTANTS = new Triple<Double>(1.0, 0.0, 0.0);
	public static final Triple<Double> RIGHT_DRIVE_PID_CONSTANTS = new Triple<Double>(1.0, 0.0, 0.0);

	// MEASUREMENTS

	public static final double LOW_ROCKET_ANGLE = 21;
	public static final double MID_ROCKET_ANGLE = 45;
	public static final double HIGH_ROCKET_ANGLE = 55;
	
	public static final double MID_ROCKET_DIST = 28;
	public static final double HIGH_ROCKET_DIST = 48;
	 
	// MISC

	public static final int RUMBLE_INTERVAL = 20;

}
