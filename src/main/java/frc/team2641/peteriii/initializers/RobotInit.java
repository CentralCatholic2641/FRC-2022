// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.initializers;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
import frc.team2641.peteriii.Robot;

public class RobotInit {
  public RobotInit() {
    CameraServer.startAutomaticCapture();

    DataLogManager.start();
    DriverStation.startDataLog(DataLogManager.getLog());

    Robot.intakeSubsystem.compressor.enableDigital();
    Robot.climberSubsystem.lock();
    Robot.intakeSubsystem.raise();

    Robot.drivingSubsystem.leftMotor1.setNeutralMode(NeutralMode.Brake);
    Robot.drivingSubsystem.leftMotor2.setNeutralMode(NeutralMode.Brake);
    Robot.drivingSubsystem.leftMotor3.setNeutralMode(NeutralMode.Brake);
    Robot.drivingSubsystem.rightMotor1.setNeutralMode(NeutralMode.Brake);
    Robot.drivingSubsystem.rightMotor2.setNeutralMode(NeutralMode.Brake);
    Robot.drivingSubsystem.rightMotor3.setNeutralMode(NeutralMode.Brake);
  }
}
