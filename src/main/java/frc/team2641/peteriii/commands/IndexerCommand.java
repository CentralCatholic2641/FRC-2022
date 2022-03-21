// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.subsystems.IndexerSubsystem;

public class IndexerCommand extends CommandBase {
  IndexerSubsystem indexerSubsystem;

  public IndexerCommand(IndexerSubsystem indexerSubsystem) {
    this.indexerSubsystem = indexerSubsystem;
    addRequirements(indexerSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.controllerShift == false) {
      indexerSubsystem.forward();
    } else {
      indexerSubsystem.backward();
    }
  }

  @Override
  public void end(boolean interrupted) {
    indexerSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
