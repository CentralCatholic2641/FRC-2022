// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Robot;

public class ClimberCommand extends CommandBase {
  int direction;
  boolean locked = false;

  public ClimberCommand(int input) {
    direction = input;
    addRequirements(Robot.climberSubsystem);
  }

  @Override
  public void initialize() {
    // if (Robot.climberSubsystem.locked()) {
    // locked = true;
    Robot.climberSubsystem.release();
    Timer.delay(0.25);
    // }
  }

  @Override
  public void execute() {
    if (direction == 1) {
      Robot.climberSubsystem.down();
    } else {
      Robot.climberSubsystem.up();
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.climberSubsystem.stop();
    // if (locked) {
    Timer.delay(0.25);
    // locked = false;
    Robot.climberSubsystem.lock();
    // }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
