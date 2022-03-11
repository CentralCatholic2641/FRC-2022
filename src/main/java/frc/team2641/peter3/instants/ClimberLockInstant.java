// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peter3.instants;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.team2641.peter3.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ClimberLockInstant extends InstantCommand {
  public ClimberLockInstant() {
    addRequirements(Robot.climberSubsystem);
  }

  @Override
  public void initialize() {
    if (Robot.climberSubsystem.climberLock.get() == DoubleSolenoid.Value.kReverse) {
      Robot.climberSubsystem.lock();
    } else {
      Robot.climberSubsystem.release();
    }

  }
}
