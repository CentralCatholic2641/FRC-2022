// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.commands.FireCommand;

public class AutoCommandGroup extends SequentialCommandGroup {
  public AutoCommandGroup() {
    Robot.drivingSubsystem.leftEncoder.setSelectedSensorPosition(0);
    Robot.drivingSubsystem.ahrs.zeroYaw();
    addCommands(new AutoDrivingCommand(6.0), new FireCommand(2));
  }
}
