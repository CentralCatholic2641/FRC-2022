// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ShooterCommand extends CommandBase {

  private int shooterSpeed;
  boolean finished = false;
  boolean forcedStop;

  public ShooterCommand(int speed, boolean force) {
    shooterSpeed = speed;
    forcedStop = force;
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
    if (forcedStop) {
      Timer.delay(2);
      end(false);
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.shooterSubsystem.stop();
    finished = true;
  }

  @Override
  public boolean isFinished() {
    return finished;
  }
}
