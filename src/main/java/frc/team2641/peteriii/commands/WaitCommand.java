package frc.team2641.peteriii.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class WaitCommand extends CommandBase {
  double time;
  boolean finished;

  public WaitCommand(double input) {
    time = input;
  }

  @Override
  public void initialize() {
    Timer.delay(time);
    end(false);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    finished = true;
  }

  @Override
  public boolean isFinished() {
    return finished;
  }
}
