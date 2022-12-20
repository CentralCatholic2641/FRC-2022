package frc.team2641.peteriii.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.commands.FireCommand;
import frc.team2641.peteriii.commands.ShooterCommand;
import frc.team2641.peteriii.commands.WaitCommand;
import frc.team2641.peteriii.subsystems.DrivingSubsystem;
import frc.team2641.peteriii.subsystems.HopperSubsystem;
import frc.team2641.peteriii.subsystems.IndexerSubsystem;
import frc.team2641.peteriii.subsystems.IntakeSubsystem;
import frc.team2641.peteriii.subsystems.ShooterSubsystem;

public class LowThenHighTarget extends SequentialCommandGroup {

  DrivingSubsystem drivingSubsystem;
  HopperSubsystem hopperSubsystem;
  IndexerSubsystem indexerSubsystem;
  IntakeSubsystem intakeSubsystem;
  ShooterSubsystem shooterSubsystem;

  public LowThenHighTarget() {

    drivingSubsystem = Robot.robotContainer.drivingSubsystem;
    hopperSubsystem = Robot.robotContainer.hopperSubsystem;
    indexerSubsystem = Robot.robotContainer.indexerSubsystem;
    intakeSubsystem = Robot.robotContainer.intakeSubsystem;
    shooterSubsystem = Robot.robotContainer.shooterSubsystem;

    addCommands(new ShooterCommand(shooterSubsystem, 1).withTimeout(2), new WaitCommand(0.5),
        new InstantCommand(indexerSubsystem::stop, indexerSubsystem),
        new AutoDrivingCommand(drivingSubsystem, 5), new WaitCommand(0.5),
        new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 2));
  }
}
