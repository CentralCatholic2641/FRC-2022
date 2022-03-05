// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.auto.AutoForFlorida;
import frc.robot.commands.DrivingCommand;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.BlockerSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.HopperSubsystem;

public class Robot extends TimedRobot {
  Command autoCommand;

  public static RobotContainer robotContainer;

  public static DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  public static IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public static ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  public static HopperSubsystem hopperSubsystem = new HopperSubsystem();
  public static BlockerSubsystem blockerSubsystem = new BlockerSubsystem();

  public static DrivingCommand drivingCommand = new DrivingCommand();

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    Robot.intakeSubsystem.compressor.enableDigital();
    CameraServer.startAutomaticCapture();
  }

  @Override
  public void robotPeriodic() {
    if (Robot.robotContainer.controller.getRawButton(Constants.leftBumper)) {
      Robot.robotContainer.controllerShift = true;
    } else {
      Robot.robotContainer.controllerShift = false;
    }

    if (Robot.robotContainer.driver.getRawButton(Constants.leftBumper)) {
      Robot.robotContainer.driverShift = true;
    } else {
      Robot.robotContainer.driverShift = false;
    }

    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    Robot.intakeSubsystem.compressor.disable();
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    Robot.intakeSubsystem.compressor.enableDigital();
    // Robot.intakeSubsystem.lower();
    // Robot.intakeSubsystem.forward();
    // Robot.hopperSubsystem.forward();
    Robot.indexerSubsystem.forward();

    Robot.drivingSubsystem.leftMotor1.configOpenloopRamp(0);
    Robot.drivingSubsystem.leftMotor2.configOpenloopRamp(0);
    Robot.drivingSubsystem.leftMotor3.configOpenloopRamp(0);
    Robot.drivingSubsystem.rightMotor1.configOpenloopRamp(0);
    Robot.drivingSubsystem.rightMotor2.configOpenloopRamp(0);
    Robot.drivingSubsystem.rightMotor3.configOpenloopRamp(0);
    Robot.drivingSubsystem.leftEncoder.setSelectedSensorPosition(0);

    autoCommand = new AutoForFlorida();

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
    if (autoCommand != null)
      autoCommand.cancel();

    // Robot.intakeSubsystem.stop();
    // Robot.hopperSubsystem.stop();
    Robot.indexerSubsystem.stop();
    Robot.intakeSubsystem.compressor.enableDigital();

    Robot.drivingSubsystem.leftMotor1.configOpenloopRamp(Constants.rampSpeed);
    Robot.drivingSubsystem.leftMotor2.configOpenloopRamp(Constants.rampSpeed);
    Robot.drivingSubsystem.leftMotor3.configOpenloopRamp(Constants.rampSpeed);
    Robot.drivingSubsystem.rightMotor1.configOpenloopRamp(Constants.rampSpeed);
    Robot.drivingSubsystem.rightMotor2.configOpenloopRamp(Constants.rampSpeed);
    Robot.drivingSubsystem.rightMotor3.configOpenloopRamp(Constants.rampSpeed);
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    Robot.intakeSubsystem.compressor.enableDigital();
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}