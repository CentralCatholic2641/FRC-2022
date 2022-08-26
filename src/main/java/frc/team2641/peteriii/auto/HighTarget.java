package frc.team2641.peteriii.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team2641.peteriii.commands.FireCommand;
import frc.team2641.peteriii.subsystems.DrivingSubsystem;
import frc.team2641.peteriii.subsystems.HopperSubsystem;
import frc.team2641.peteriii.subsystems.IndexerSubsystem;
import frc.team2641.peteriii.subsystems.IntakeSubsystem;
import frc.team2641.peteriii.subsystems.ShooterSubsystem;

public class HighTarget extends SequentialCommandGroup {
  public HighTarget(DrivingSubsystem drivingSubsystem, IntakeSubsystem intakeSubsystem, HopperSubsystem hopperSubsystem,
      IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem) {
    drivingSubsystem.resetEncoder();
    drivingSubsystem.ahrs.zeroYaw();
    intakeSubsystem.lower();
    addCommands(new AutoDrivingCommand(drivingSubsystem, 6.0), new AutoDrivingCommand(drivingSubsystem, -1.5),
        new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 2));
  }
}
