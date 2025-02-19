package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Constants;
import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.subsystems.DrivingSubsystem;

public class DrivingCommand extends CommandBase {
  private DrivingSubsystem drivingSubsystem;

  public DrivingCommand(DrivingSubsystem drivingSubsystem) {
    this.drivingSubsystem = drivingSubsystem;
    addRequirements(this.drivingSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.driverShift == true) {
      double left = Robot.robotContainer.driver.getRawAxis(Constants.GamepadButtons.lyAxis);
      double right = Robot.robotContainer.driver.getRawAxis(Constants.GamepadButtons.ryAxis);
      drivingSubsystem.tDrive(-left, right);
    } else {
      double rotation = Robot.robotContainer.driver.getRawAxis(Constants.GamepadButtons.lxAxis);
      double drive = Robot.robotContainer.driver.getRawAxis(Constants.GamepadButtons.ryAxis);
      drivingSubsystem.aDrive(rotation, drive);
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}