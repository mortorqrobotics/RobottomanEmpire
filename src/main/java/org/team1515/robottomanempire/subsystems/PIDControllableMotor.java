package org.team1515.robottomanempire.subsystems;

import org.team1515.robottomanempire.subsystems.MotorModule;
import org.team1515.robottomanempire.subsystems.encoders.AbsoluteEncoder;
import org.team1515.robottomanempire.subsystems.encoders.DIOEncoder;
import org.team1515.robottomanempire.subsystems.encoders.GenericEncoder;
import org.team1515.robottomanempire.subsystems.encoders.SRXMagneticEncoder;
import org.team1515.robottomanempire.util.PIDController;
import org.team1515.robottomanempire.util.Pair;
import org.team1515.robottomanempire.util.Triple;

public class PIDControllableMotor {

  private MotorModule motors;
  private GenericEncoder encoder;
  private PIDController pidController;

  private PIDControllableMotor(int[] talonIds, Triple<Double> pidConstants) {
    motors = new MotorModule(talonIds);
    pidController = new PIDController(pidConstants);
  }

  public PIDControllableMotor(int[] talonIds, int encoderId, Pair<Double> voltageMinMax, Triple<Double> pidConstants) {
    this(talonIds, pidConstants);
    encoder = new AbsoluteEncoder(encoderId, voltageMinMax);
  }

  public PIDControllableMotor(int[] talonIds, int encoderId, Triple<Double> pidConstants) {
    this(talonIds, pidConstants);
    encoder = new SRXMagneticEncoder(motors.getTalonOfId(encoderId));
  }

  public PIDControllableMotor(int[] talonIds, Pair<Integer> encoderId, Triple<Double> pidConstants) {
    this(talonIds, pidConstants);
    encoder = new DIOEncoder(encoderId);
  }

  public void setSpeed(double speed) {
    motors.setSpeed(speed);
  }

  public void setSpeedPID(double target) {
    double output = pidController.getOutput(target, getEncoderMeasurement());
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