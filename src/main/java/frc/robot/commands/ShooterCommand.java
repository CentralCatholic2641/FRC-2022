// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ShooterCommand extends CommandBase {

  private int shooterSpeed;

  /** Creates a new ShooterCommand. */
  public ShooterCommand(int speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooterSpeed = speed;
    addRequirements(Robot.shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (shooterSpeed == 0) {
      Robot.shooterSubsystem.lowTarget();
    } else if (shooterSpeed == 1) {
      Robot.shooterSubsystem.highTarget();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.shooterSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
