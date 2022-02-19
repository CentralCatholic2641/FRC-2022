// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IndexerCommand extends CommandBase {
  boolean goForward;

  public IndexerCommand(boolean goforward) {
    addRequirements(Robot.indexerSubsystem);
    goForward = goforward;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (goForward == true) {
      Robot.indexerSubsystem.goForward();
    } else {
      Robot.indexerSubsystem.goBackward();
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
