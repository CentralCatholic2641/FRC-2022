// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeCommand extends CommandBase {

  int direction;

  public IntakeCommand(int input) {
    direction = input;
    addRequirements(Robot.intakeSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (direction == 1) {
      Robot.intakeSubsystem.forward();
    } else if (direction == -1) {
      Robot.intakeSubsystem.backward();
    } else if (direction == 2) {
      Robot.intakeSubsystem.raise();
    } else if (direction == -2) {
      Robot.intakeSubsystem.lower();
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.intakeSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
