// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

  public WPI_TalonFX climberMotor = new WPI_TalonFX(Constants.climberMotor);

  public ClimberSubsystem() {
  }

  public void up() {
    climberMotor.set(0.50);
  }

  public void down() {
    climberMotor.set(-0.50);
  }

  public void stop() {
    climberMotor.set(0);
  }

  @Override
  public void periodic() {
  }
}
