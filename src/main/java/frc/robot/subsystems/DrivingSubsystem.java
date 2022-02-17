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

  public WPI_TalonFX leftmotor1 = new WPI_TalonFX(Constants.leftmotor1);
  public WPI_TalonFX leftmotor2 = new WPI_TalonFX(Constants.leftmotor2);
  public WPI_TalonFX leftmotor3 = new WPI_TalonFX(Constants.leftmotor3);

  public MotorControllerGroup leftgroup = new MotorControllerGroup(leftmotor1, leftmotor2, leftmotor3);

  public WPI_TalonFX rightmotor1 = new WPI_TalonFX(Constants.rightmotor1);
  public WPI_TalonFX rightmotor2 = new WPI_TalonFX(Constants.rightmotor2);
  public WPI_TalonFX rightmotor3 = new WPI_TalonFX(Constants.rightmotor3);

  public MotorControllerGroup rightgroup = new MotorControllerGroup(rightmotor1, rightmotor2, rightmotor3);

  public WPI_TalonFX leftEncoder = new WPI_TalonFX(Constants.leftEncoder);
  public WPI_TalonFX rightEncoder = new WPI_TalonFX(Constants.rightEncoder);

  public DifferentialDrive differentialDrive = new DifferentialDrive(leftgroup, rightgroup);

  public AHRS ahrs;

  public void oDrive(double y1, double y2) {
    differentialDrive.arcadeDrive(y1, y2, true);
  }

  public void tDrive(double left, double right) {
    differentialDrive.tankDrive(-left, -right, true);
  }

  public DrivingSubsystem() {
    ahrs = new AHRS();
    ahrs.zeroYaw();
  }

  public void periodic() {
    setDefaultCommand(new DrivingCommand());
  }
}