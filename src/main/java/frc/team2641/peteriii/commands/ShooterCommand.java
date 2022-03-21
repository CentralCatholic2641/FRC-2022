// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {
  ShooterSubsystem shooterSubsystem;
  private int shooterSpeed;
  boolean forcedStop;

  public ShooterCommand(ShooterSubsystem shooterSubsystem, int speed) {
    this.shooterSubsystem = shooterSubsystem;
    this.shooterSpeed = speed;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.controllerShift == false) {
      if (shooterSpeed == 1) {
        shooterSubsystem.lowTarget();
      } else if (shooterSpeed == 2) {
        shooterSubsystem.highTarget();
      }
    } else {
      shooterSubsystem.reverse();
    }
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
