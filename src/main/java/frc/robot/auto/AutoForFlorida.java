// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ShooterCommand;

public class AutoForFlorida extends SequentialCommandGroup {
  public AutoForFlorida() {
    addCommands(new ShooterCommand(1, true), new AutoDrivingCommand(6.0));
  }
}