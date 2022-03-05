// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BlockerSubsystem extends SubsystemBase {
  public DoubleSolenoid blockerSolenoid = new DoubleSolenoid(21, PneumaticsModuleType.CTREPCM, 2, 3);

  public BlockerSubsystem() {
  }

  public void extend() {
    blockerSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retract() {
    blockerSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
  }
}
