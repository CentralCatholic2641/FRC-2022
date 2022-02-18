// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivingCommand extends CommandBase {

  public DrivingCommand() {
    addRequirements(Robot.drivingSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("encoder", -Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() / 2048);
    double joystick1 = Robot.robotContainer.gamepad1.getRawAxis(Constants.joystick2);
    double joystick2 = Robot.robotContainer.gamepad1.getRawAxis(Constants.joystick1);
    Robot.drivingSubsystem.oDrive(joystick1 / 2, -joystick2);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}