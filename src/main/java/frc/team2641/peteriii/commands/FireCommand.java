// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.subsystems.HopperSubsystem;
import frc.team2641.peteriii.subsystems.IndexerSubsystem;
import frc.team2641.peteriii.subsystems.IntakeSubsystem;
import frc.team2641.peteriii.subsystems.ShooterSubsystem;

public class FireCommand extends CommandBase {
  IntakeSubsystem intakeSubsystem;
  HopperSubsystem hopperSubsystem;
  IndexerSubsystem indexerSubsystem;
  ShooterSubsystem shooterSubsystem;
  int speed;

  public FireCommand(IntakeSubsystem intakeSubsystem, HopperSubsystem hopperSubsystem,
      IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem, int speed) {
    this.hopperSubsystem = hopperSubsystem;
    this.indexerSubsystem = indexerSubsystem;
    this.shooterSubsystem = shooterSubsystem;
    this.intakeSubsystem = intakeSubsystem;
    this.speed = speed;

    addRequirements(hopperSubsystem, indexerSubsystem, shooterSubsystem, intakeSubsystem);
  }

  @Override
  public void initialize() {
    // Robot.intakeSubsystem.stop();
    // Robot.hopperSubsystem.stop();
    if (speed == 1) {
      shooterSubsystem.lowTarget();
    } else if (speed == 2) {
      shooterSubsystem.highTarget();
    }
    Timer.delay(0.75);
    intakeSubsystem.forward();
    hopperSubsystem.forward();
    indexerSubsystem.forward();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stop();
    hopperSubsystem.stop();
    indexerSubsystem.stop();
    shooterSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
