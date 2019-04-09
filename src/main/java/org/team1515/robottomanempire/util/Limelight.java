package org.team1515.robottomanempire.util;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

	private NetworkTable table;

	public Limelight() {
		this.table = NetworkTableInstance.getDefault().getTable("limelight");
	}

	public setLedMode(int mode) { //Requires indents
		return table.getEntry("ledMode").setNumber(mode);
	}

	public boolean isTargetDetected() {
		return table.getEntry("tv").getDouble(0) > 0;
	}

	public double getHorizontalOffset() {
		return table.getEntry("tx").getDouble(0);
	}

	public double getArea() {
		return table.getEntry("ta").getDouble(0);
	}

}
