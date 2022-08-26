package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.subsystems.IntakeSubsystem;

public class IntakeMotorCommand extends CommandBase {
  IntakeSubsystem intakeSubsystem;

  public IntakeMotorCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.controllerShift == false) {
      intakeSubsystem.forward();
    } else {
      intakeSubsystem.backward();
    }
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
