// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class FireCommand extends CommandBase {
  int speed;
  boolean finished = false;
  boolean forceStopped;

  public FireCommand(int input, boolean force) {
    speed = input;
    forceStopped = force;
    addRequirements(Robot.hopperSubsystem, Robot.indexerSubsystem, Robot.shooterSubsystem, Robot.intakeSubsystem);
  }

  @Override
  public void initialize() {
    // Robot.intakeSubsystem.stop();
    // Robot.hopperSubsystem.stop();
  }

  @Override
  public void execute() {
    if (speed == 1) {
      Robot.shooterSubsystem.lowTarget();
    } else if (speed == 2) {
      Robot.shooterSubsystem.highTarget();
    }
    Timer.delay(0.75);
    Robot.intakeSubsystem.forward();
    Robot.hopperSubsystem.forward();
    Robot.indexerSubsystem.forward();
    if (forceStopped) {
      Timer.delay(1.5);
      Robot.intakeSubsystem.stop();
      Robot.hopperSubsystem.stop();
      Robot.indexerSubsystem.stop();
      Robot.shooterSubsystem.stop();
      end(false);
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.intakeSubsystem.stop();
    Robot.hopperSubsystem.stop();
    Robot.indexerSubsystem.stop();
    Robot.shooterSubsystem.stop();
    finished = true;
  }

  @Override
  public boolean isFinished() {
    return finished;
  }
}
