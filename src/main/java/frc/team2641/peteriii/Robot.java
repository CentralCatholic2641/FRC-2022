// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.team2641.peteriii.commands.DrivingCommand;
import frc.team2641.peteriii.initializers.*;
import frc.team2641.peteriii.instants.StopInstant;
import frc.team2641.peteriii.subsystems.*;
import frc.team2641.peteriii.telemetry.ShuffleboardController;

public class Robot extends TimedRobot {
  Command autoCommand;

  public static RobotContainer robotContainer;

  public static DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  public static IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public static ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  public static HopperSubsystem hopperSubsystem = new HopperSubsystem();

  static DrivingCommand drivingCommand = new DrivingCommand();
  static AnalogInput distanceSensor = new AnalogInput(3);

  public static ShuffleboardController shuffleboard = new ShuffleboardController();

  @Override
  public void robotInit() {
    new RobotInit();
    robotContainer = new RobotContainer();
    Robot.shuffleboard.preMatch();
  }

  @Override
  public void robotPeriodic() {
    if (Robot.robotContainer.controller.getRawButton(Constants.GamepadButtons.leftBumper)) {
      Robot.robotContainer.controllerShift = true;
    } else {
      Robot.robotContainer.controllerShift = false;
    }

    if (Robot.robotContainer.driver.getRawButton(Constants.GamepadButtons.leftBumper)) {
      Robot.robotContainer.driverShift = true;
    } else {
      Robot.robotContainer.driverShift = false;
    }

    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("distance", distanceSensor.getVoltage());
  }

  @Override
  public void disabledInit() {
    Robot.shuffleboard.disabled();
    Robot.intakeSubsystem.compressor.disable();
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    Robot.shuffleboard.auto();
    new AutonomousInit();

    // autoCommand = shuffleboard.getAutonomousCommand();
    autoCommand = new StopInstant("indexer");
    CommandScheduler.getInstance().registerSubsystem(drivingSubsystem);
    if (autoCommand != null)
      autoCommand.schedule();
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    Robot.shuffleboard.teleop();
    new TeleopInit();

    if (autoCommand != null)
      autoCommand.cancel();
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    Robot.intakeSubsystem.compressor.enableDigital();
    CommandScheduler.getInstance().cancelAll();
    Robot.shuffleboard.test();
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