package org.team1515.robottomanempire.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDController {

	private final double K_P;
	private final double K_I;
	private final double K_D;

	double p_term;
	double i_term;
	double d_term;

	double error;
	double lastError;
	double errorSum;

	double target;
	double actual;
	double output;

	public PIDController(Triple<Double> pidConstants) {
		this.K_P = pidConstants.first;
		this.K_I = pidConstants.second;
		this.K_D = pidConstants.last;
	}

	public double getOutput(double target, double actual) {
		this.target = target;
		this.actual = actual;

		error = target - actual;

		p_term = error * K_P;

		errorSum += error;
		i_term = errorSum * K_I;

		d_term = (error - lastError);
		d_term *= K_D;

		lastError = error;
		output = p_term + i_term + d_term;

		return output;
	}

	public void reset() {
		p_term = 0;
		i_term = 0;
		d_term = 0;

		error = 0;
		lastError = 0;
		errorSum = 0;
	}

	public void printToSmartDashboard(String identifier) {
		SmartDashboard.putNumber(identifier + " target", target);
		SmartDashboard.putNumber(identifier + " measured", actual);
		SmartDashboard.putNumber(identifier + " output", output);

		SmartDashboard.putNumber(identifier + " error", error);
		SmartDashboard.putNumber(identifier + " p_term", p_term);
		SmartDashboard.putNumber(identifier + " i_term", i_term);
		SmartDashboard.putNumber(identifier + " d_term", d_term);
	}

}
