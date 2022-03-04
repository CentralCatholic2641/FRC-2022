// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class FireCommand extends CommandBase {
  int speed;

  public FireCommand(int input) {
    speed = input;
    addRequirements(Robot.hopperSubsystem, Robot.indexerSubsystem, Robot.shooterSubsystem);
  }

  @Override
  public void initialize() {
    if (speed == 1) {
      Robot.shooterSubsystem.lowTarget();
    } else if (speed == 2) {
      Robot.shooterSubsystem.highTarget();
    }
    Timer.delay(1.5);
    Robot.hopperSubsystem.forward();
    Robot.indexerSubsystem.forward();
  }

  @Override
  public void execute() {
    // if (speed == 1) {
    // Robot.shooterSubsystem.lowTarget();
    // } else if (speed == 2) {
    // Robot.shooterSubsystem.highTarget();
    // }
    // Timer.delay(1.5);
    // Robot.hopperSubsystem.forward();
    // Robot.indexerSubsystem.forward();
  }

  @Override
  public void end(boolean interrupted) {
    Robot.hopperSubsystem.stop();
    Robot.indexerSubsystem.stop();
    Robot.shooterSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
