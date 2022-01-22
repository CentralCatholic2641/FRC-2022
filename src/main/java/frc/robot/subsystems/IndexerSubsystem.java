// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexerSubsystem extends SubsystemBase {
  /** Creates a new Indexer. */

  public WPI_TalonSRX indexmotor1 = new WPI_TalonSRX(Constants.indexMotor1);
  public WPI_TalonSRX indexmotor2 = new WPI_TalonSRX(Constants.indexmotor2);

  public MotorControllerGroup indexergroup = new MotorControllerGroup(indexmotor1, indexmotor2);

  public IndexerSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void goForward() {
    indexergroup.set(Constants.indexerSpeed);
  }

  public void goBackward() {
    indexergroup.set(-Constants.indexerSpeed);
  }

}
