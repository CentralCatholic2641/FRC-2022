// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class StopCommand extends CommandBase {
  String stopping;
  boolean finished = false;

  public StopCommand(String toStop) {
    stopping = toStop;
    addRequirements(Robot.indexerSubsystem);
  }

  @Override
  public void initialize() {
    if (stopping == "indexer") {
      Robot.indexerSubsystem.stop();
    }
    end(false);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    finished = true;
  }

  @Override
  public boolean isFinished() {
    return finished;
  }
}
