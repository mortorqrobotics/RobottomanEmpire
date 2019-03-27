package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.subsystems.MotorModule;
import org.team1515.robottomanempire.subsystems.encoders.GenericEncoder;
import org.team1515.robottomanempire.subsystems.encoders.SRXMagneticEncoder;
import org.team1515.robottomanempire.util.PIDController;
import org.team1515.robottomanempire.util.Triple;

public class PIDControllableMotor {

	private MotorModule motors;
	private GenericEncoder encoder;
	private PIDController pidController;

	private double maxSpeed;

	private PIDControllableMotor(int[] talonIds, Triple<Double> pidConstants, double maxSpeed) {
		motors = new MotorModule(talonIds);
		pidController = new PIDController(pidConstants);
		this.maxSpeed = maxSpeed;
	}

	public PIDControllableMotor(int[] talonIds, Triple<Double> pidConstants, GenericEncoder encoder) {
		this(talonIds, pidConstants, 1.0);
		this.encoder = encoder;
	}

	public PIDControllableMotor(int[] talonIds, Triple<Double> pidConstants, GenericEncoder encoder, double maxSpeed) {
		this(talonIds, pidConstants, maxSpeed);
		this.encoder = encoder;
	}

	public PIDControllableMotor(int[] talonIds, Triple<Double> pidConstants, int encoderTalonId) {
		this(talonIds, pidConstants, 1.0);
		encoder = new SRXMagneticEncoder(motors.getTalonOfId(encoderTalonId));
	}

	public void setSpeed(double speed) {
		motors.setSpeed(speed);
	}

	public void setSpeedPID(double target) {
		double output = pidController.getOutput(target, getEncoderMeasurement());
		if (Math.abs(output) > maxSpeed) {
			output = Math.signum(output) * maxSpeed;
		}
		setSpeed(output);
	}

	public void stop() {
		motors.stop();
	}

	public double getEncoderMeasurement() {
		return encoder.get();
	}

	public void resetEncoder() {
		encoder.reset();
	}

	public void print(String identifier) {
		pidController.printToSmartDashboard(identifier);
	}

}
