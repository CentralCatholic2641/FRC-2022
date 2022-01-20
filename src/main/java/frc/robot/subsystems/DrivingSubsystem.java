// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.Constants;
import frc.robot.commands.DrivingCommand;

public class DrivingSubsystem extends SubsystemBase {

  public WPI_TalonSRX leftmotor1 = new WPI_TalonSRX(Constants.leftmotor1);
  public WPI_TalonSRX leftmotor2 = new WPI_TalonSRX(Constants.leftmotor2);

  public MotorControllerGroup leftgroup = new MotorControllerGroup(leftmotor1, leftmotor2);

  public WPI_TalonSRX rightmotor1 = new WPI_TalonSRX(Constants.rightmotor1);
  public WPI_TalonSRX rightmotor2 = new WPI_TalonSRX(Constants.rightmotor2);

  public MotorControllerGroup rightgroup = new MotorControllerGroup(rightmotor1, rightmotor2);

  public WPI_TalonSRX leftEncoder = new WPI_TalonSRX(Constants.leftEncoder);
  public WPI_TalonSRX rightEncoder = new WPI_TalonSRX(Constants.rightEncoder);
  
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