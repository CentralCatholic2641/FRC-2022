// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii.telemetry;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
// import frc.team2641.peteriii.Robot;
import frc.team2641.peteriii.auto.*;
import frc.team2641.peteriii.subsystems.*;
// import frc.team2641.peteriii.commands.TestCommand;

public class ShuffleboardController {
  public ShuffleboardTab preMatchTab = Shuffleboard.getTab("Pre-Match");
  public ShuffleboardTab autoTab = Shuffleboard.getTab("Auto");
  public ShuffleboardTab teleopTab = Shuffleboard.getTab("Teleop");
  public ShuffleboardTab testTab = Shuffleboard.getTab("Test");

  private final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  private final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  // private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  private final HopperSubsystem hopperSubsystem = new HopperSubsystem();

  SendableChooser<Command> autoChooser = new SendableChooser<>();

  public ShuffleboardController() {
    // Pre-match
    autoChooser.setDefaultOption("Auto For Florida",
        new AutoForFlorida(drivingSubsystem, intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem));
    autoChooser.addOption("Low Then High Target",
        new LowThenHighTarget(drivingSubsystem, intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem));
    preMatchTab.add("Auto", autoChooser).withSize(2, 1);
    preMatchTab.addCamera("Intake", "Intake", "/dev/video0");
    preMatchTab.addCamera("Driver", "Driver", "/dev/video1");

    // Test
    // testTab.add("Test", new TestCommand()).withSize(2, 1);

    // Autonomous
    autoTab.addCamera("Intake", "Intake", "/dev/video0").withPosition(0, 0).withSize(5, 5);
    autoTab.addCamera("Driver", "Driver", "/dev/video1").withPosition(5, 0).withSize(5, 5);

    // Teleop
    teleopTab.addCamera("Intake", "Intake", "/dev/video0").withPosition(0, 0).withSize(5, 5);
    teleopTab.addCamera("Driver", "Driver", "/dev/video1").withPosition(5, 0).withSize(5, 5);
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

  public void preMatch() {
    Shuffleboard.selectTab("Pre-Match");
  }

  public void auto() {
    Shuffleboard.selectTab("Auto");
  }

  public void teleop() {
    Shuffleboard.selectTab("Teleop");
  }

  public void disabled() {
    Shuffleboard.selectTab("Pre-Match");
  }

  public void test() {
    Shuffleboard.selectTab("Test");
  }
}
