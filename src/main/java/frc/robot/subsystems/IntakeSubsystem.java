// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
// import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  public Compressor compressor = new Compressor(21, PneumaticsModuleType.CTREPCM);
  // public WPI_TalonSRX intakemotor1 = new WPI_TalonSRX(Constants.intakemotor1);

  public IntakeSubsystem() {
  }

  public void start() {
    compressor.enableDigital();
  }

  public void stop() {
    compressor.disable();
  }

  public void intake() {
    // intakemotor1.set(0.9);
    // compressor.enableDigital();
  }

  @Override
  public void periodic() {
  }
}
