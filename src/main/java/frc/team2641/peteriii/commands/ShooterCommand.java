// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Robot;

public class ShooterCommand extends CommandBase {

  private int shooterSpeed;
  boolean forcedStop;

  public ShooterCommand(int speed) {
    shooterSpeed = speed;
    addRequirements(Robot.shooterSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (shooterSpeed == 1) {
      Robot.shooterSubsystem.lowTarget();
    } else if (shooterSpeed == 2) {
      Robot.shooterSubsystem.highTarget();
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.shooterSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
