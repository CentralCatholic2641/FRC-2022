// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IndexerCommand extends CommandBase {
  int direction;

  public IndexerCommand(int input) {
    direction = input;
    addRequirements(Robot.indexerSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (direction == 1) {
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
