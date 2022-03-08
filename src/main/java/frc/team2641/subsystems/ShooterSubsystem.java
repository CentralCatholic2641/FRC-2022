// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ShooterSubsystem extends SubsystemBase {

  public WPI_TalonFX shooterMotor = new WPI_TalonFX(Constants.shooterMotor);

  public ShooterSubsystem() {
    shooterMotor.clearStickyFaults();
  }

  public void highTarget() {
    shooterMotor.set(Constants.highShooterSpeed);
  }

  public void lowTarget() {
    shooterMotor.set(Constants.lowShooterSpeed);
  }

  public void stop() {
    shooterMotor.stopMotor();
    shooterMotor.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void periodic() {
  }
}
