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
import frc.team2641.peteriii.subsystems.DrivingSubsystem;
import frc.team2641.peteriii.subsystems.HopperSubsystem;
import frc.team2641.peteriii.subsystems.IndexerSubsystem;
import frc.team2641.peteriii.subsystems.IntakeSubsystem;
import frc.team2641.peteriii.subsystems.ShooterSubsystem;

public class AutoForFlorida extends SequentialCommandGroup {
  public AutoForFlorida(DrivingSubsystem drivingSubsystem, IntakeSubsystem intakeSubsystem,
      HopperSubsystem hopperSubsystem, IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem) {
    addCommands(
        new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 1).withTimeout(2),
        new AutoDrivingCommand(drivingSubsystem, 9).alongWith(
            new IntakeMotorCommand(intakeSubsystem),
            new HopperCommand(hopperSubsystem)).withTimeout(4),
        new IntakePistonCommand(intakeSubsystem).withTimeout(1),
        new IntakeMotorCommand(intakeSubsystem)
            .alongWith(new HopperCommand(hopperSubsystem), new IndexerCommand(indexerSubsystem)).withTimeout(0.5),
        new AutoDrivingCommand(drivingSubsystem, -9),
        new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 1).withTimeout(2));
  }
}