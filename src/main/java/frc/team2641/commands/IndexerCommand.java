// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.Robot;

public class IndexerCommand extends CommandBase {
  public IndexerCommand() {
    addRequirements(Robot.indexerSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.controllerShift == false) {
      Robot.indexerSubsystem.forward();
    } else {
      Robot.indexerSubsystem.backward();
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.indexerSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
