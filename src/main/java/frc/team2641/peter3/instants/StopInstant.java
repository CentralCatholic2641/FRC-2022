// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peter3.instants;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.team2641.peter3.Robot;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class StopInstant extends InstantCommand {
  String stopping;

  public StopInstant(String toStop) {
    stopping = toStop;
    addRequirements(Robot.indexerSubsystem);
  }

  @Override
  public void initialize() {
    switch (stopping) {
      case "intake":
        Robot.intakeSubsystem.stop();
        break;
      case "hopper":
        Robot.hopperSubsystem.stop();
        break;
      case "indexer":
        Robot.indexerSubsystem.stop();
        break;
      case "shooter":
        Robot.shooterSubsystem.stop();
        break;
      case "climber":
        Robot.climberSubsystem.stop();
        break;
      case "drivetrain":
        Robot.drivingSubsystem.halt();
        break;
      case "pneumatics":
        Robot.intakeSubsystem.compressor.disable();
        break;
    }
  }
}
