// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class FireCommand extends CommandBase {

  int direction;

  public FireCommand(int input) {
    direction = input;
    addRequirements(Robot.hopperSubsystem, Robot.indexerSubsystem, Robot.shooterSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.shooterSubsystem.highTarget();
    Timer.delay(1);
    Robot.hopperSubsystem.forward();
    Robot.indexerSubsystem.forward();
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
