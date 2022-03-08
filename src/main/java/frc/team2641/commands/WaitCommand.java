// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class WaitCommand extends CommandBase {
  double time;
  boolean finished;

  public WaitCommand(double input) {
    time = input;
  }

  @Override
  public void initialize() {
    Timer.delay(time);
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
