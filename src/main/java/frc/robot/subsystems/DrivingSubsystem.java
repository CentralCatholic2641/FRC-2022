// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.Constants;
import frc.robot.commands.DrivingCommand;

public class DrivingSubsystem extends SubsystemBase {

  public WPI_TalonFX leftMotor1 = new WPI_TalonFX(Constants.leftMotor1);
  public WPI_TalonFX leftMotor2 = new WPI_TalonFX(Constants.leftMotor2);
  public WPI_TalonFX leftMotor3 = new WPI_TalonFX(Constants.leftMotor3);

  public MotorControllerGroup leftGroup = new MotorControllerGroup(leftMotor1, leftMotor2, leftMotor3);

  public WPI_TalonFX rightMotor1 = new WPI_TalonFX(Constants.rightMotor1);
  public WPI_TalonFX rightMotor2 = new WPI_TalonFX(Constants.rightMotor2);
  public WPI_TalonFX rightMotor3 = new WPI_TalonFX(Constants.rightMotor3);

  public MotorControllerGroup rightGroup = new MotorControllerGroup(rightMotor1, rightMotor2, rightMotor3);

  public WPI_TalonFX leftEncoder = new WPI_TalonFX(Constants.leftEncoder);
  public WPI_TalonFX rightEncoder = new WPI_TalonFX(Constants.rightEncoder);

  public DifferentialDrive differentialDrive = new DifferentialDrive(leftGroup, rightGroup);

  public AHRS ahrs;

  public void aDrive(double rotation, double speed) {
    differentialDrive.arcadeDrive(rotation * Constants.slowRotateFactor, speed * Constants.slowDriveFactor, true);
  }

  public void tDrive(double left, double right) {
    differentialDrive.tankDrive(-left * Constants.slowDriveFactor, -right * Constants.slowDriveFactor, true);
  }

  public DrivingSubsystem() {
    ahrs = new AHRS();
    ahrs.zeroYaw();

    leftMotor1.clearStickyFaults();
    leftMotor2.clearStickyFaults();
    leftMotor3.clearStickyFaults();

    rightMotor1.clearStickyFaults();
    rightMotor2.clearStickyFaults();
    rightMotor3.clearStickyFaults();
  }

  public void periodic() {
    setDefaultCommand(new DrivingCommand());
  }
}