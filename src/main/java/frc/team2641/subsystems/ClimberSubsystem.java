// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClimberSubsystem extends SubsystemBase {
  public DoubleSolenoid climberLock = new DoubleSolenoid(21, PneumaticsModuleType.CTREPCM, 0, 1);
  public WPI_TalonFX climberMotor = new WPI_TalonFX(Constants.climberMotor);

  public ClimberSubsystem() {
    climberMotor.clearStickyFaults();
    release();
  }

  public void lock() {
    climberLock.set(DoubleSolenoid.Value.kForward);
  }

  public void release() {
    climberLock.set(DoubleSolenoid.Value.kReverse);
  }

  public void up() {
    climberMotor.set(Constants.climberSpeed);
  }

  public void down() {
    climberMotor.set(-Constants.climberSpeed);
  }

  public void stop() {
    climberMotor.stopMotor();
  }

  public boolean locked() {
    return climberLock.get() == DoubleSolenoid.Value.kForward;
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Climber Lock", locked());
  }
}
