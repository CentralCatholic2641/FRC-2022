// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexerSubsystem extends SubsystemBase {
  public WPI_TalonSRX indexMotor = new WPI_TalonSRX(Constants.indexMotor);

  public IndexerSubsystem() {
  }

  @Override
  public void periodic() {
  }

  public void forward() {
    indexMotor.set(0.25);
  }

  public void backward() {
    indexMotor.set(-0.25);
  }

  public void stop() {
    indexMotor.set(0);
  }
}
