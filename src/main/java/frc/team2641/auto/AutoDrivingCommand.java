// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.auto;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.Constants;
import frc.team2641.Robot;

public class AutoDrivingCommand extends CommandBase {

  double output = 0;
  double I = 0;
  double distanceTravelled = 0;
  double error;
  double errorPrevious;
  double D = 0;
  double setpoint = 0;
  int sign = 1;

  public AutoDrivingCommand(double distance) {
    addRequirements(Robot.drivingSubsystem);
    if (distance > 0) {
      sign = 1;
    } else {
      sign = -1;
    }
    setpoint = distance;
    errorPrevious = distance;
    error = distance;
  }

  @Override
  public void initialize() {
    // Robot.drivingSubsystem.leftEncoder.setSelectedSensorPosition(0);
    // SmartDashboard.delete("error");
    // SmartDashboard.delete("output");
    // SmartDashboard.delete("angle");
  }

  @Override
  public void execute() {
    distanceTravelled = ((-Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() / Constants.oneRotation)
        * (Math.PI * Constants.wheelDiameter)) / 12;

    error = setpoint - distanceTravelled;
    I += (error * 1);
    D = (error - errorPrevious);
    output = sign * ((Constants.kP * error) + (Constants.kI * I) + (Constants.kD * D))
        / ((Constants.kP) * setpoint) / 2;
    errorPrevious = error;

    // System.out.println("distance: " + distanceTravelled + ", encoder: "
    // + Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() + ", error:
    // " + error + ", output:"
    // + output);

    // SmartDashboard.putNumber("encoder",
    // -Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition());
    // SmartDashboard.putNumber("rotations",
    // (-Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() /
    // Constants.oneRotation));
    // SmartDashboard.putNumber("error", error);
    // SmartDashboard.putNumber("output", output);
    // SmartDashboard.putNumber("angle", Robot.drivingSubsystem.ahrs.getAngle() *
    // Constants.driftCompensation);
    // SmartDashboard.putNumber("travelled", distanceTravelled);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.drivingSubsystem.leftEncoder.setSelectedSensorPosition(0);
  }

  @Override
  public boolean isFinished() {
    if (output > 0.35) {
      // Robot.drivingSubsystem.tDrive(-Robot.drivingSubsystem.ahrs.getAngle() *
      // Constants.driftCompensation, output);
      Robot.drivingSubsystem.tDrive(-output, output);
      return false;
    } else {
      Robot.drivingSubsystem.tDrive(0, 0);
      return true;
    }
  }
}
