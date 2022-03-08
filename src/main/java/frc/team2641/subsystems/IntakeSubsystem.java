// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.Constants;
import edu.wpi.first.wpilibj.Compressor;

public class IntakeSubsystem extends SubsystemBase {
  public Compressor compressor = new Compressor(21, PneumaticsModuleType.CTREPCM);
  public DoubleSolenoid intakeSolenoid = new DoubleSolenoid(21, PneumaticsModuleType.CTREPCM, 4, 5);
  public WPI_TalonSRX intakeMotor = new WPI_TalonSRX(Constants.intakeMotor);

  public IntakeSubsystem() {
    intakeMotor.clearStickyFaults();
  }

  public void stop() {
    intakeMotor.stopMotor();
  }

  public void raise() {
    intakeSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void lower() {
    intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void forward() {
    intakeMotor.set(-Constants.intakeSpeed);
  }

  public void backward() {
    intakeMotor.set(Constants.intakeSpeed);
  }

  @Override
  public void periodic() {
  }
}
