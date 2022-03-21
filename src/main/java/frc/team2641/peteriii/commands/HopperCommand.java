// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.subsystems.HopperSubsystem;

public class HopperCommand extends CommandBase {
  HopperSubsystem hopperSubsystem;

  public HopperCommand(HopperSubsystem hopperSubsystem) {
    this.hopperSubsystem = hopperSubsystem;
    addRequirements(hopperSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.controllerShift == false) {
      hopperSubsystem.forward();
    } else {
      hopperSubsystem.backward();
    }
  }

  @Override
  public void end(boolean interrupted) {
    hopperSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
