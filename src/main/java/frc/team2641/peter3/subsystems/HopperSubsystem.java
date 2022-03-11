// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peter3.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.peter3.Constants;

public class HopperSubsystem extends SubsystemBase {
  public WPI_TalonSRX hopperMotor1 = new WPI_TalonSRX(Constants.hopperMotor1);
  public WPI_TalonSRX hopperMotor2 = new WPI_TalonSRX(Constants.hopperMotor2);

  public HopperSubsystem() {
    hopperMotor1.clearStickyFaults();
    hopperMotor2.clearStickyFaults();
  }

  public void forward() {
    hopperMotor1.set(-Constants.hopperSpeed);
    hopperMotor2.set(Constants.hopperSpeed);
  }

  public void backward() {
    hopperMotor1.set(Constants.hopperSpeed);
    hopperMotor2.set(-Constants.hopperSpeed);
  }

  public void stop() {
    hopperMotor1.stopMotor();
    hopperMotor2.stopMotor();
  }

  @Override
  public void periodic() {
  }
}
