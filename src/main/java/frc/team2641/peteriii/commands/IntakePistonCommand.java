package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.subsystems.IntakeSubsystem;

public class IntakePistonCommand extends CommandBase {
  IntakeSubsystem intakeSubsystem;

  public IntakePistonCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {
    if (intakeSubsystem.intakeSolenoid.get() == DoubleSolenoid.Value.kReverse) {
      intakeSubsystem.raise();
    } else {
      intakeSubsystem.lower();
    }
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
