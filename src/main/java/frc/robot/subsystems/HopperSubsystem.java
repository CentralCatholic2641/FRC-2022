// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HopperSubsystem extends SubsystemBase {
  public WPI_TalonSRX hopperMotor = new WPI_TalonSRX(Constants.intakemotor1);

  public HopperSubsystem() {
  }

  public void forward() {
    hopperMotor.set(1);
  }

  public void backward() {
    hopperMotor.set(-1);
  }

  public void stop() {
    hopperMotor.set(0);
  }

  @Override
  public void periodic() {
  }
}
