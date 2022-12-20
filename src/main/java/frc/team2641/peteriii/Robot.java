package frc.team2641.peteriii;

import java.io.IOException;
import java.nio.file.Path;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  Command autoCommand;

  public static RobotContainer robotContainer;
  public static final Field2d field = new Field2d();

  String trajectoryJSON = "paths/Test.wpilib.json";
  String trajectoryJSON2 = "paths/Test2.wpilib.json";
  Trajectory trajectory = new Trajectory();
  Trajectory trajectory2 = new Trajectory();

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    SmartDashboard.putData(field);
    field.setRobotPose(robotContainer.drivingSubsystem.getPose());

    try {
      Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
      trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);

      Path trajectoryPath2 = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON2);
      trajectory2 = TrajectoryUtil.fromPathweaverJson(trajectoryPath2);

      robotContainer.drivingSubsystem.resetPose(trajectory.getInitialPose());
    } catch (IOException ex) {
      DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON, ex.getStackTrace());
    }

    field.getObject("traj").setTrajectory(trajectory);
    field.getObject("traj2").setTrajectory(trajectory2);
  }

  @Override
  public void robotPeriodic() {
    if (robotContainer.driver.getRawButton(Constants.GamepadButtons.leftBumper)) {
      robotContainer.driverShift = true;
    } else {
      robotContainer.driverShift = false;
    }

    CommandScheduler.getInstance().run();

    field.setRobotPose(robotContainer.drivingSubsystem.getPose());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    autoCommand = robotContainer.getAutonomousCommand();
    robotContainer.drivingSubsystem.configRamps(0);

    if (autoCommand != null)
      autoCommand.schedule();
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    robotContainer.drivingSubsystem.configRamps(Constants.MotorSpeeds.driveRampSpeed);

    if (autoCommand != null)
      autoCommand.cancel();
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}