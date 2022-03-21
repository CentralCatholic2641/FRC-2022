// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

// import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.subsystems.ClimberSubsystem;

public class ClimberCommand extends CommandBase {
  private final ClimberSubsystem climberSubsystem;
  int direction;
  boolean locked = false;

  public ClimberCommand(ClimberSubsystem climberSubsystem, int direction) {
    this.climberSubsystem = climberSubsystem;
    this.direction = direction;
    addRequirements(climberSubsystem);
  }

  @Override
  public void initialize() {
    // if (Robot.climberSubsystem.locked()) {
    // locked = true;
    // Robot.climberSubsystem.release();
    // Timer.delay(0.025);
    // }
  }

  @Override
  public void execute() {
    if (direction == 1) {
      climberSubsystem.down();
    } else {
      climberSubsystem.up();
    }
  }

  @Override
  public void end(boolean interrupted) {
    climberSubsystem.stop();
    // if (locked) {
    // Timer.delay(0.025);
    // locked = false;
    // Robot.climberSubsystem.lock();
    // }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
