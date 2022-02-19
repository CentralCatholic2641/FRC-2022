// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeCommand extends CommandBase {
  public IntakeCommand() {
    // addRequirements(Robot.intakeSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.intakeSubsystem.start();
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
