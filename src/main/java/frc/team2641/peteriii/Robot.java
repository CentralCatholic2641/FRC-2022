// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj.I2C;
// import edu.wpi.first.wpilibj.AnalogInput;
// import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.Relay.Value;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
// import frc.team2641.peteriii.commands.DrivingCommand;
// import frc.team2641.peteriii.subsystems.*;
// import frc.team2641.peteriii.instants.StopInstant;
import frc.team2641.peteriii.telemetry.ShuffleboardController;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;

public class Robot extends TimedRobot {
  Command autoCommand;

  public static RobotContainer robotContainer;

  // private final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  // private final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  // private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  // private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  // private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  // private final HopperSubsystem hopperSubsystem = new HopperSubsystem();

  // static DrivingCommand drivingCommand = new DrivingCommand();
  // static AnalogInput distanceSensor = new AnalogInput(3);
  // static Relay distanceSensorTrigger = new Relay(3);
  // private I2C i2c;
  // private byte[] distance;
  // private final int LIDAR_ADDR = 0x62;
  // private final int LIDAR_CONFIG_REGISTER = 0x00;
  // private final int LIDAR_DISTANCE_REGISTER = 0x8f;

  public static UsbCamera intakeCamera;
  public static UsbCamera driverCamera;

  public static ShuffleboardController shuffleboard;

  // public void getDistance() {
  // int distCM = (int) Integer.toUnsignedLong(distance[0] << 8) +
  // Byte.toUnsignedInt(distance[1]);
  // System.out.println(distCM);
  // // return distCM / 100; for testing it will just print the distance
  // }

  // private void update() {
  // i2c.write(LIDAR_CONFIG_REGISTER, 0x04);
  // Timer.delay(0.04);
  // i2c.read(LIDAR_DISTANCE_REGISTER, 2, distance);
  // Timer.delay(0.005);
  // getDistance();
  // }

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();

    intakeCamera = CameraServer.startAutomaticCapture("Intake", "/dev/video0");
    driverCamera = CameraServer.startAutomaticCapture("Driver", "/dev/video1");
    DataLogManager.start();
    DriverStation.startDataLog(DataLogManager.getLog());

    shuffleboard.preMatch();

    // i2c = new I2C(I2C.Port.kOnboard, LIDAR_ADDR);
    // distance = new byte[2];

    // while (true) {
    // distanceSensorTrigger.set(Value.kForward);
    // Timer.delay(0.1);
    // distanceSensorTrigger.set(Value.kReverse);
    // Timer.delay(5);
    // }
  }

  @Override
  public void robotPeriodic() {
    if (robotContainer.controller.getRawButton(Constants.GamepadButtons.leftBumper)) {
      robotContainer.controllerShift = true;
    } else {
      robotContainer.controllerShift = false;
    }

    if (robotContainer.driver.getRawButton(Constants.GamepadButtons.leftBumper)) {
      robotContainer.driverShift = true;
    } else {
      robotContainer.driverShift = false;
    }

    CommandScheduler.getInstance().run();

    // update();

    // SmartDashboard.putNumber("distance", distanceSensor.getVoltage());
  }

  @Override
  public void disabledInit() {
    shuffleboard.disabled();
    robotContainer.intakeSubsystem.compressor.disable();
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    shuffleboard.auto();

    robotContainer.intakeSubsystem.compressor.enableDigital();
    robotContainer.intakeSubsystem.lower();

    robotContainer.drivingSubsystem.configRamps(0);
    robotContainer.drivingSubsystem.resetEncoder();

    autoCommand = shuffleboard.getAutonomousCommand();
    // autoCommand = new StopInstant("indexer");
    CommandScheduler.getInstance().registerSubsystem(robotContainer.drivingSubsystem);
    if (autoCommand != null)
      autoCommand.schedule();
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    shuffleboard.teleop();
    // Robot.intakeSubsystem.stop();
    // Robot.hopperSubsystem.stop();
    robotContainer.indexerSubsystem.stop();
    robotContainer.intakeSubsystem.compressor.enableDigital();
    robotContainer.drivingSubsystem.configRamps(Constants.MotorSpeeds.driveRampSpeed);

    if (autoCommand != null)
      autoCommand.cancel();
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    robotContainer.intakeSubsystem.compressor.enableDigital();
    CommandScheduler.getInstance().cancelAll();
    shuffleboard.test();
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