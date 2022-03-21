// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.team2641.peteriii.Constants;
import frc.team2641.peteriii.subsystems.DrivingSubsystem;

public class PIDDrivingCommand extends PIDCommand {
  public PIDDrivingCommand(double setpoint, DrivingSubsystem drivingSubsystem) {
    super(
        new PIDController(Constants.PID.kP, Constants.PID.kI, Constants.PID.kD),
        drivingSubsystem::getDistance,
        setpoint,
        output -> drivingSubsystem.aDrive(output, 0));
    addRequirements(drivingSubsystem);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
