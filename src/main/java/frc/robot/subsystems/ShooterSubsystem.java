// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ShooterSubsystem extends SubsystemBase {

  public WPI_TalonFX shooterMotor = new WPI_TalonFX(Constants.shooterMotor);

  public ShooterSubsystem() {
  }

  public void highTarget() {
    shooterMotor.set(1);
  }

  public void lowTarget() {
    shooterMotor.set(0.5);
  }

  public void stop() {
    shooterMotor.set(0);
    shooterMotor.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("encoder", shooterMotor.getSelectedSensorPosition());
  }
}
