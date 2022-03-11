// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class TestCommand extends SequentialCommandGroup {
  public TestCommand() {
    addCommands(new IntakeMotorCommand().withTimeout(1), new HopperCommand().withTimeout(1),
        new IndexerCommand().withTimeout(1), new ShooterCommand(1).withTimeout(1), new IntakePistonCommand(),
        new IntakePistonCommand(), new ClimberCommand(2).withTimeout(1.5), new ClimberCommand(1).withTimeout(1.5));
  }
}
