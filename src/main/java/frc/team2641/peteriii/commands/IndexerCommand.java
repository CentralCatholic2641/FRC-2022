package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.subsystems.IndexerSubsystem;

public class IndexerCommand extends CommandBase {
  IndexerSubsystem indexerSubsystem;

  public IndexerCommand(IndexerSubsystem indexerSubsystem) {
    this.indexerSubsystem = indexerSubsystem;
    addRequirements(indexerSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.robotContainer.controllerShift == false) {
      indexerSubsystem.forward();
    } else {
      indexerSubsystem.backward();
    }
  }

  @Override
  public void end(boolean interrupted) {
    indexerSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
