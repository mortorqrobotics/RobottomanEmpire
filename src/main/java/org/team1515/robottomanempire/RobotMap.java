/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team1515.robottomanempire;

import org.team1515.robottomanempire.util.Pair;

public class RobotMap {

	public static final int[] LEFT_DRIVE_TALONS = {32, 34};
	public static final int[] RIGHT_DRIVE_TALONS = {31, 35};

	public static final Pair<Integer> LEFT_DRIVE_ENCODER = new Pair<Integer>(0, 1);
	public static final Pair<Integer> RIGHT_DRIVE_ENCODER = new Pair<Integer>(2, 3);

	public static final int[] SHOOTING_TALONS = {32};
	public static final int[] ARM_TALONS = {2};

	public static final int ARM_ENCODER = 0;
	public static final Pair<Double> ARM_ENCODER_MIN_MAX = new Pair<Double>(0.01464, 4.814);

	public static final Pair<Integer> PANELER_SOLENOID = new Pair<Integer>(0, 1);

	public static final int PCM = 11;

}
