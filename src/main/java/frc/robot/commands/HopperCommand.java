// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class HopperCommand extends CommandBase {
  public HopperCommand() {
    addRequirements(Robot.hopperSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.controllerDirection == 1) {
      Robot.hopperSubsystem.forward();
    } else {
      Robot.hopperSubsystem.backward();
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.hopperSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
