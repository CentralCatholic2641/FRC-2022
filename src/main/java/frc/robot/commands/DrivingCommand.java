// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.Constants;
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
    double left = Robot.robotContainer.driver.getRawAxis(Constants.lyAxis);
    double right = Robot.robotContainer.driver.getRawAxis(Constants.ryAxis);
    Robot.drivingSubsystem.tDrive(-left, right);

    // double joystick1 =
    // Robot.robotContainer.controller1.getRawAxis(Constants.joystick2);
    // double joystick2 =
    // Robot.robotContainer.controller1.getRawAxis(Constants.joystick1);
    // Robot.drivingSubsystem.oDrive(joystick1, -joystick2);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}