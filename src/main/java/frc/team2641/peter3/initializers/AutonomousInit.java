// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peter3.initializers;

import frc.team2641.peter3.Robot;

public class AutonomousInit {
  public AutonomousInit() {
    Robot.intakeSubsystem.compressor.enableDigital();

    Robot.drivingSubsystem.leftMotor1.configOpenloopRamp(0);
    Robot.drivingSubsystem.leftMotor2.configOpenloopRamp(0);
    Robot.drivingSubsystem.leftMotor3.configOpenloopRamp(0);
    Robot.drivingSubsystem.rightMotor1.configOpenloopRamp(0);
    Robot.drivingSubsystem.rightMotor2.configOpenloopRamp(0);
    Robot.drivingSubsystem.rightMotor3.configOpenloopRamp(0);
    Robot.drivingSubsystem.rightEncoder.setSelectedSensorPosition(0);
  }
}
