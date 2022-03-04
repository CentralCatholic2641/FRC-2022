// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakePistonCommand extends CommandBase {
  public IntakePistonCommand() {
    addRequirements(Robot.intakeSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.intakeSubsystem.solenoid.get() == DoubleSolenoid.Value.kReverse) {
      Robot.intakeSubsystem.raise();
    } else {
      Robot.intakeSubsystem.lower();
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
