/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.util.Pair;

public class RobotMap {

	public static final int[] LEFT_TALON_IDS = {1, 2};
	public static final int[] RIGHT_TALON_IDS = {3, 4};

	public static final Pair<Integer> LEFT_ENCODER_PORTS = new Pair<Integer>(0, 1);
	public static final Pair<Integer> RIGHT_ENCODER_PORTS = new Pair<Integer>(2, 3);

	public static final Pair<Integer> PANELER_SOLENOID_PORTS = new Pair<Integer>(0, 1);

	public static final int PCM = 11;

}
