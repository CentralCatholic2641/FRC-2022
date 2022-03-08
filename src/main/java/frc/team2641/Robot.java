// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.team2641.auto.AutoForFlorida;
import frc.team2641.commands.DrivingCommand;
import frc.team2641.initializers.AutonomousInit;
import frc.team2641.initializers.RobotInit;
import frc.team2641.initializers.TeleopInit;
import frc.team2641.subsystems.ClimberSubsystem;
import frc.team2641.subsystems.DrivingSubsystem;
import frc.team2641.subsystems.HopperSubsystem;
import frc.team2641.subsystems.IndexerSubsystem;
import frc.team2641.subsystems.IntakeSubsystem;
import frc.team2641.subsystems.ShooterSubsystem;

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

  @Override
  public void robotInit() {
    new RobotInit();
    robotContainer = new RobotContainer();
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
    new AutonomousInit();

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