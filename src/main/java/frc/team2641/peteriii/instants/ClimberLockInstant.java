// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.instants;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.team2641.peteriii.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ClimberLockInstant extends InstantCommand {
  ClimberSubsystem climberSubsystem;

  public ClimberLockInstant(ClimberSubsystem climberSubsystem) {
    this.climberSubsystem = climberSubsystem;
    addRequirements(climberSubsystem);
  }

  @Override
  public void initialize() {
    if (climberSubsystem.climberLock.get() == DoubleSolenoid.Value.kReverse) {
      climberSubsystem.lock();
    } else {
      climberSubsystem.release();
    }
  }
}
