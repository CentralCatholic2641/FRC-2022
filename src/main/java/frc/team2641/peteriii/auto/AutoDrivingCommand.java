package frc.team2641.peteriii.auto;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Constants;
import frc.team2641.peteriii.subsystems.DrivingSubsystem;

public class AutoDrivingCommand extends CommandBase {
  DrivingSubsystem drivingSubsystem;
  double output = 0;
  double I = 0;
  double distanceTravelled = 0;
  double error;
  double errorPrevious;
  double D = 0;
  double setpoint = 0;
  int sign = 1;

  public AutoDrivingCommand(DrivingSubsystem drivingSubsystem, double distance) {
    this.drivingSubsystem = drivingSubsystem;
    addRequirements(drivingSubsystem);
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
    // Robot.drivingSubsystem.rightEncoder.setSelectedSensorPosition(0);
    // SmartDashboard.delete("error");
    // SmartDashboard.delete("output");
    // SmartDashboard.delete("angle");
  }

  @Override
  public void execute() {
    distanceTravelled = ((-drivingSubsystem.rightEncoder.getSelectedSensorPosition() / Constants.oneRotation)
        * (Math.PI * Constants.wheelDiameter)) / 12;

    error = setpoint - distanceTravelled;
    I += (error * 1);
    D = (error - errorPrevious);
    output = 0.7 * ((Constants.PID.kP * error) + (Constants.PID.kI * I) + (Constants.PID.kD * D))
        / ((Constants.PID.kP) * setpoint);
    errorPrevious = error;

    // System.out.println("distance: " + distanceTravelled + ", encoder: "
    // + Robot.drivingSubsystem.rightEncoder.getSelectedSensorPosition() + ", error:
    // " + error + ", output:"
    // + output);

    // SmartDashboard.putNumber("encoder",
    // -Robot.drivingSubsystem.rightEncoder.getSelectedSensorPosition());
    // SmartDashboard.putNumber("rotations",
    // (-Robot.drivingSubsystem.rightEncoder.getSelectedSensorPosition() /
    // Constants.oneRotation));
    // SmartDashboard.putNumber("error", error);
    // SmartDashboard.putNumber("output", output);
    // SmartDashboard.putNumber("angle", Robot.drivingSubsystem.ahrs.getAngle() *
    // Constants.driftCompensation);
    // SmartDashboard.putNumber("travelled", distanceTravelled);
  }

  @Override
  public void end(boolean interrupted) {
    drivingSubsystem.resetEncoders();
  }

  @Override
  public boolean isFinished() {
    if (output > 0.35) {
      // Robot.drivingSubsystem.aDrive(-sign * Robot.drivingSubsystem.ahrs.getAngle()
      // *
      // Constants.driftCompensation, sign * output);
      drivingSubsystem.tDrive(sign * -output, sign * output);
      return false;
    } else {
      drivingSubsystem.tDrive(0, 0);
      return true;
    }
  }
}
