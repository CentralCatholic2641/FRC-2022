// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ClimberCommand extends CommandBase {

  int direction;

  public ClimberCommand(int input) {
    direction = input;
    addRequirements(Robot.climberSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (direction == 1) {
      Robot.climberSubsystem.down();
    } else {
      Robot.climberSubsystem.up();
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.climberSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}