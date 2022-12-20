package frc.team2641.peteriii;

import java.util.List;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.team2641.peteriii.commands.*;
import frc.team2641.peteriii.subsystems.*;

public class RobotContainer {
  public final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  public final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  public final HopperSubsystem hopperSubsystem = new HopperSubsystem();

  public XboxController driver = new XboxController(Constants.Controllers.driver);
  public JoystickButton driverFireHighButton = new JoystickButton(driver,
          Constants.GamepadButtons.rightBumper);
  public JoystickButton driverFireLowButton = new JoystickButton(driver,
          Constants.GamepadButtons.yButton);

  public XboxController controller = new XboxController(Constants.Controllers.controller);
  public JoystickButton controllerFireButton = new JoystickButton(controller, Constants.GamepadButtons.rightBumper);
  public JoystickButton controllerIntakeButton = new JoystickButton(controller, Constants.GamepadButtons.aButton);
  public JoystickButton controllerHopperButton = new JoystickButton(controller, Constants.GamepadButtons.xButton);
  public JoystickButton controllerIndexerButton = new JoystickButton(controller, Constants.GamepadButtons.yButton);
  public JoystickButton controllerShooterButton = new JoystickButton(controller, Constants.GamepadButtons.bButton);
  public JoystickButton controllerFireLowButton = new JoystickButton(controller,
          Constants.GamepadButtons.startButton);
  public POVButton controllerClimberUpDpad = new POVButton(controller, 0);
  public POVButton controllerClimberDownDpad = new POVButton(controller, 180);
  public POVButton controllerIntakeToggle = new POVButton(controller, 90);
  public boolean controllerShift = false;
  public boolean driverShift = false;

  public RobotContainer() {
    configureButtonBindings();
    drivingSubsystem.setDefaultCommand(new DrivingCommand(drivingSubsystem));
  }

  private void configureButtonBindings() {
    driverFireLowButton
    .whileHeld(new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 1));
driverFireHighButton
    .whileHeld(new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 2));

controllerIntakeButton.whileHeld(new IntakeMotorCommand(intakeSubsystem));
controllerHopperButton.whileHeld(new HopperCommand(hopperSubsystem));
controllerIndexerButton.whileHeld(new IndexerCommand(indexerSubsystem));
controllerShooterButton.whileHeld(new ShooterCommand(shooterSubsystem, 2));
controllerClimberUpDpad.whileHeld(new ClimberCommand(climberSubsystem, 1));
controllerClimberDownDpad.whileHeld(new ClimberCommand(climberSubsystem, -1));
controllerIntakeToggle.whileHeld(new IntakePistonCommand(intakeSubsystem));
controllerFireLowButton
    .whileHeld(new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 1));
  }

  public Command getAutonomousCommand() {
    var autoVoltageConstraint = new DifferentialDriveVoltageConstraint(
        new SimpleMotorFeedforward(
            Constants.DriveConstants.ksVolts,
            Constants.DriveConstants.kvVoltSecondsPerMeter,
            Constants.DriveConstants.kaVoltSecondsSquaredPerMeter),
        Constants.DriveConstants.kDriveKinematics,
        10);

    // Create config for trajectory
    TrajectoryConfig config = new TrajectoryConfig(
        Constants.DriveConstants.kMaxSpeedMetersPerSecond,
        Constants.DriveConstants.kMaxAccelerationMetersPerSecondSquared)
        // Add kinematics to ensure max speed is actually obeyed
        .setKinematics(Constants.DriveConstants.kDriveKinematics)
        // Apply the voltage constraint
        .addConstraint(autoVoltageConstraint);

    // An example trajectory to follow. All units in meters.
    Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0, 0, new Rotation2d(0)),
        // Pass through these two interior waypoints, making an 's' curve path
        List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
        // End 3 meters straight ahead of where we started, facing forward
        new Pose2d(3, 0, new Rotation2d(0)),
        // Pass config
        config);

    RamseteCommand ramseteCommand = new RamseteCommand(
        exampleTrajectory,
        Robot.robotContainer.drivingSubsystem::getPose,
        new RamseteController(Constants.DriveConstants.kRamseteB, Constants.DriveConstants.kRamseteZeta),
        new SimpleMotorFeedforward(
            Constants.DriveConstants.ksVolts,
            Constants.DriveConstants.kvVoltSecondsPerMeter,
            Constants.DriveConstants.kaVoltSecondsSquaredPerMeter),
        Constants.DriveConstants.kDriveKinematics,
        Robot.robotContainer.drivingSubsystem::getWheelSpeeds,
        new PIDController(Constants.DriveConstants.kPDriveVel, 0, 0),
        new PIDController(Constants.DriveConstants.kPDriveVel, 0, 0),
        // RamseteCommand passes volts to the callback
        Robot.robotContainer.drivingSubsystem::tDriveVolts,
        Robot.robotContainer.drivingSubsystem);

    Transform2d tranform = new Pose2d(2, 2, new Rotation2d()).minus(exampleTrajectory.getInitialPose());
    exampleTrajectory = exampleTrajectory.transformBy(tranform);
    Robot.field.getObject("traj3").setTrajectory(exampleTrajectory);

    // Reset odometry to the starting pose of the trajectory.
    Robot.robotContainer.drivingSubsystem.resetPose(exampleTrajectory.getInitialPose());

    return ramseteCommand.andThen(() -> Robot.robotContainer.drivingSubsystem.tDriveVolts(0, 0));
  }
}