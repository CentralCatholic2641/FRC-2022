package frc.team2641.peteriii.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.peteriii.Constants;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClimberSubsystem extends SubsystemBase {
  public DoubleSolenoid climberLock = new DoubleSolenoid(21, PneumaticsModuleType.CTREPCM, 7, 6);
  public WPI_TalonFX climberMotor = new WPI_TalonFX(Constants.Motors.climberMotor);

  public ClimberSubsystem() {
    climberMotor.clearStickyFaults();
    climberMotor.setNeutralMode(NeutralMode.Brake);
    release();
  }

  public void lock() {
    climberLock.set(DoubleSolenoid.Value.kForward);
  }

  public void release() {
    climberLock.set(DoubleSolenoid.Value.kReverse);
  }

  public void up() {
    climberMotor.set(Constants.MotorSpeeds.climberSpeed);
  }

  public void down() {
    climberMotor.set(-Constants.MotorSpeeds.climberSpeed);
  }

  public void stop() {
    climberMotor.stopMotor();
  }

  public boolean locked() {
    return climberLock.get() == DoubleSolenoid.Value.kForward;
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Climber Lock", locked());
  }
}
