// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.peteriii.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ShooterSubsystem extends SubsystemBase {

  public WPI_TalonFX shooterMotor = new WPI_TalonFX(Constants.Motors.shooterMotor);

  public ShooterSubsystem() {
    shooterMotor.clearStickyFaults();
  }

  public void highTarget() {
    shooterMotor.set(Constants.MotorSpeeds.highShooterSpeed);
  }

  public void lowTarget() {
    shooterMotor.set(Constants.MotorSpeeds.lowShooterSpeed);
  }

  public void stop() {
    shooterMotor.stopMotor();
    shooterMotor.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void periodic() {
  }
}
