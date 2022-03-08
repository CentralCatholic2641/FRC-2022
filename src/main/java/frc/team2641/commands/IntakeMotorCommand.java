// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.Robot;

public class IntakeMotorCommand extends CommandBase {
  public IntakeMotorCommand() {
    addRequirements(Robot.intakeSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.controllerShift == false) {
      Robot.intakeSubsystem.forward();
    } else {
      Robot.intakeSubsystem.backward();
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
