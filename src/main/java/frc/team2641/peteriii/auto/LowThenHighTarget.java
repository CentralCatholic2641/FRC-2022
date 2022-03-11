// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team2641.peteriii.commands.FireCommand;
import frc.team2641.peteriii.commands.ShooterCommand;
import frc.team2641.peteriii.commands.WaitCommand;
import frc.team2641.peteriii.instants.StopInstant;

// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LowThenHighTarget extends SequentialCommandGroup {
  public LowThenHighTarget() {
    addCommands(new ShooterCommand(1).withTimeout(2), new WaitCommand(0.5), new StopInstant("indexer"),
        new AutoDrivingCommand(5), new WaitCommand(0.5),
        new FireCommand(2));
  }
}
