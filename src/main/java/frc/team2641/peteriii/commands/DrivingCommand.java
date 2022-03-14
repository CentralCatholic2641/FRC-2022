// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Constants;
import frc.team2641.peteriii.Robot;

public class DrivingCommand extends CommandBase {

  public DrivingCommand() {
    addRequirements(Robot.drivingSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    // if (Robot.robotContainer.driverShift == true) {
    // double left =
    // Robot.robotContainer.driver.getRawAxis(Constants.GamepadButtons.lyAxis);
    // double right =
    // Robot.robotContainer.driver.getRawAxis(Constants.GamepadButtons.ryAxis);
    // Robot.drivingSubsystem.tDrive(-left, right);
    // } else {
    // double rotation =
    // Robot.robotContainer.driver.getRawAxis(Constants.GamepadButtons.lxAxis);
    // double speed =
    // Robot.robotContainer.driver.getRawAxis(Constants.GamepadButtons.ryAxis);
    // Robot.drivingSubsystem.aDrive(rotation, speed);
    // }

    double drive = Robot.robotContainer.driver.getRawAxis(Constants.JoystickButtons.yAxis);
    double rotate = Robot.robotContainer.driver.getRawAxis(Constants.JoystickButtons.zRotate);
    Robot.drivingSubsystem.aDrive(rotate * Constants.MotorSpeeds.rotateFactor,
        drive * Constants.MotorSpeeds.driveFactor);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}