// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.commands.FireCommand;

public class HighTarget extends SequentialCommandGroup {
  public HighTarget() {
    Robot.drivingSubsystem.rightEncoder.setSelectedSensorPosition(0);
    Robot.drivingSubsystem.ahrs.zeroYaw();
    Robot.intakeSubsystem.lower();
    addCommands(new AutoDrivingCommand(6.0), new AutoDrivingCommand(-1.5), new FireCommand(2));
  }
}
