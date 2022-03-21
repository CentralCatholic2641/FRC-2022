// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team2641.peteriii.subsystems.ClimberSubsystem;
import frc.team2641.peteriii.subsystems.HopperSubsystem;
import frc.team2641.peteriii.subsystems.IndexerSubsystem;
import frc.team2641.peteriii.subsystems.IntakeSubsystem;
import frc.team2641.peteriii.subsystems.ShooterSubsystem;

public class TestCommand extends SequentialCommandGroup {
  public TestCommand(IntakeSubsystem intakeSubsystem, HopperSubsystem hopperSubsystem,
      IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem, ClimberSubsystem climberSubsystem) {
    addCommands(new IntakeMotorCommand(intakeSubsystem).withTimeout(1),
        new HopperCommand(hopperSubsystem).withTimeout(1),
        new IndexerCommand(indexerSubsystem).withTimeout(1), new ShooterCommand(shooterSubsystem, 1).withTimeout(1),
        new IntakePistonCommand(intakeSubsystem),
        new IntakePistonCommand(intakeSubsystem), new ClimberCommand(climberSubsystem, 2).withTimeout(1.5),
        new ClimberCommand(climberSubsystem, 1).withTimeout(1.5));
  }
}
