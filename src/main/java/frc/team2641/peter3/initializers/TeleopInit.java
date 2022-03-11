// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peter3.initializers;

import frc.team2641.peter3.Constants;
import frc.team2641.peter3.Robot;

public class TeleopInit {
  public TeleopInit() {
    // Robot.intakeSubsystem.stop();
    // Robot.hopperSubsystem.stop();
    Robot.indexerSubsystem.stop();
    Robot.intakeSubsystem.compressor.enableDigital();

    Robot.drivingSubsystem.leftMotor1.configOpenloopRamp(Constants.driveRampSpeed);
    Robot.drivingSubsystem.leftMotor2.configOpenloopRamp(Constants.driveRampSpeed);
    Robot.drivingSubsystem.leftMotor3.configOpenloopRamp(Constants.driveRampSpeed);
    Robot.drivingSubsystem.rightMotor1.configOpenloopRamp(Constants.driveRampSpeed);
    Robot.drivingSubsystem.rightMotor2.configOpenloopRamp(Constants.driveRampSpeed);
    Robot.drivingSubsystem.rightMotor3.configOpenloopRamp(Constants.driveRampSpeed);
  }
}
