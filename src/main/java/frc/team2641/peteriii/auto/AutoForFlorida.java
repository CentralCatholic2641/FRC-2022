// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team2641.peteriii.commands.FireCommand;
import frc.team2641.peteriii.commands.HopperCommand;
import frc.team2641.peteriii.commands.IndexerCommand;
import frc.team2641.peteriii.commands.IntakeMotorCommand;
import frc.team2641.peteriii.commands.IntakePistonCommand;

public class AutoForFlorida extends SequentialCommandGroup {
  public AutoForFlorida() {
    addCommands(
        new FireCommand(1).withTimeout(2),
        new AutoDrivingCommand(9).alongWith(
            new IntakeMotorCommand(),
            new HopperCommand()).withTimeout(4),
        new IntakePistonCommand().withTimeout(1),
        new IntakeMotorCommand().alongWith(new HopperCommand(), new IndexerCommand()).withTimeout(0.5),
        new AutoDrivingCommand(-9),
        new FireCommand(1).withTimeout(2));
  }
}