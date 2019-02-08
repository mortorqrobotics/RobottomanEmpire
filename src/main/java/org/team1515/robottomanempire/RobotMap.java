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

	public static final int[] LEFT_DRIVE_TALON_IDS = {31, 33, 35};
	public static final int[] RIGHT_DRIVE_TALON_IDS = {32, 34, 40};

	public static final int LEFT_DRIVE_ENCODER_ID = 41;
	public static final int RIGHT_DRIVE_ENCODER_ID = 40; 

	public static final int[] LEFT_SHOOTER_TALON_IDS = {35};
	public static final int[] RIGHT_SHOOTER_TALON_IDS = {34};

	public static final Pair<Integer> LEFT_SHOOTER_ENCODER_ID = new Pair<Integer>(0, 1);
	public static final Pair<Integer> RIGHT_SHOOTER_ENCODER_ID = new Pair<Integer>(2, 3);

	public static final int[] ARM_TALON_IDS = {33};

	public static final int ARM_ENCODER_ID = 0;
	public static final Pair<Double> ARM_ENCODER_MIN_MAX = new Pair<Double>(0.01464, 4.814);

	public static final Pair<Integer> PANELER_SOLENOID_ID = new Pair<Integer>(0, 1);
	public static final int PCM_ID = 12;

	// SPEEDS

	public static final double SHOOTING_SPEED = 0.3;
	public static final double INTAKE_SPEED = 0.3;
	public static final double ARM_SPEED = 0.6;

	// PID CONSTANTS

    public static final Triple<Double> SHOOTER_PID_CONSTANTS = new Triple<Double>(0.4, 0.1, 0.0);
    public static final Triple<Double> ARM_PID_CONSTANTS = new Triple<Double>(1.0, 0.0, 0.0);
    public static final Triple<Double> LEFT_DRIVE_PID_CONSTANTS = new Triple<Double>(1.0, 0.0, 0.0);
	public static final Triple<Double> RIGHT_DRIVE_PID_CONSTANTS = new Triple<Double>(1.0, 0.0, 0.0);
	
	// MISC

	public static final int RUMBLE_INTERVAL = 20;

}
