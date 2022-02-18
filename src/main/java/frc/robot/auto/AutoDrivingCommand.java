// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;

public class AutoDrivingCommand extends CommandBase {

  double lOutput = 0;
  double lI = 0;
  double lDistanceTravelled = 0;
  double lError;
  double lErrorPrevious;
  double lD = 0;
  double setpoint = 0;

  public AutoDrivingCommand(double distance) {
    addRequirements(Robot.drivingSubsystem);
    setpoint = distance;
    lErrorPrevious = distance;
    lError = distance;
  }

  @Override
  public void initialize() {
    // Robot.drivingSubsystem.leftEncoder.setSelectedSensorPosition(0);
    Robot.drivingSubsystem.ahrs.zeroYaw();
    SmartDashboard.delete("error");
    SmartDashboard.delete("output");
    SmartDashboard.delete("angle");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lDistanceTravelled = ((-Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() / Constants.oneRotation)
        * (Math.PI * Constants.wheelDiameter)) / 12;

    lError = setpoint - lDistanceTravelled;
    lI += (lError * 1);
    // lD = (lError - lErrorPrevious) / .02;
    lD = (lError - lErrorPrevious);
    lOutput = ((Constants.kP * lError) + (Constants.kI * lI) + (Constants.kD * lD))
        / ((Constants.kP) * setpoint);
    lErrorPrevious = lError;

    System.out.println("distance: " + lDistanceTravelled + ", encoder: "
        + Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() + ", error: " + lError + ", output:"
        + lOutput);

    SmartDashboard.putNumber("encoder", -Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition());
    SmartDashboard.putNumber("rotations",
        (-Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() / Constants.oneRotation));
    SmartDashboard.putNumber("error", lError);
    SmartDashboard.putNumber("output", lOutput);
    SmartDashboard.putNumber("angle", Robot.drivingSubsystem.ahrs.getAngle() * Constants.driftCompensation);
    SmartDashboard.putNumber("travelled", lDistanceTravelled);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drivingSubsystem.leftEncoder.setSelectedSensorPosition(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (lOutput > 0.25) {
      Robot.drivingSubsystem.oDrive(0, lOutput);
      return false;
    } else {
      Robot.drivingSubsystem.tDrive(0, 0);
      return true;
    }
  }
}
