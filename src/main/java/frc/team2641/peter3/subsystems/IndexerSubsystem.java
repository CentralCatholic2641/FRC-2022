// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peter3.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.peter3.Constants;

public class IndexerSubsystem extends SubsystemBase {
  public WPI_TalonSRX indexerMotor = new WPI_TalonSRX(Constants.indexerMotor);

  public IndexerSubsystem() {
    indexerMotor.clearStickyFaults();
  }

  @Override
  public void periodic() {
  }

  public void forward() {
    indexerMotor.set(Constants.indexerSpeed);
  }

  public void backward() {
    indexerMotor.set(-Constants.indexerSpeed);
  }

  public void stop() {
    indexerMotor.stopMotor();
  }
}
