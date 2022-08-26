package frc.team2641.peteriii.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.peteriii.Constants;

public class HopperSubsystem extends SubsystemBase {
  public WPI_TalonSRX hopperMotor1 = new WPI_TalonSRX(Constants.Motors.hopperMotor1);
  public WPI_TalonSRX hopperMotor2 = new WPI_TalonSRX(Constants.Motors.hopperMotor2);

  public HopperSubsystem() {
    hopperMotor1.clearStickyFaults();
    hopperMotor2.clearStickyFaults();
  }

  public void forward() {
    hopperMotor1.set(-Constants.MotorSpeeds.hopperSpeed);
    hopperMotor2.set(Constants.MotorSpeeds.hopperSpeed);
  }

  public void backward() {
    hopperMotor1.set(Constants.MotorSpeeds.hopperSpeed);
    hopperMotor2.set(-Constants.MotorSpeeds.hopperSpeed);
  }

  public void stop() {
    hopperMotor1.stopMotor();
    hopperMotor2.stopMotor();
  }

  @Override
  public void periodic() {
  }
}
