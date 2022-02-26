// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.Compressor;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  // public Compressor compressor = new Compressor(21,
  // PneumaticsModuleType.CTREPCM);
  public DoubleSolenoid solenoid = new DoubleSolenoid(21, PneumaticsModuleType.CTREPCM, 4, 5);
  public WPI_TalonSRX intakeMotor = new WPI_TalonSRX(Constants.intakeMotor);

  public IntakeSubsystem() {
  }

  // public void start() {
  // compressor.enableDigital();
  // }

  public void stop() {
    // compressor.disable();
    intakeMotor.set(0);
  }

  public void raise() {
    solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void lower() {
    solenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void forward() {
    intakeMotor.set(-0.35);
  }

  public void backward() {
    intakeMotor.set(0.35);
  }

  @Override
  public void periodic() {
  }
}
