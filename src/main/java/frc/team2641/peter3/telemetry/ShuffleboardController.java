// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peter3.telemetry;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.team2641.peter3.auto.*;
import frc.team2641.peter3.commands.TestCommand;

public class ShuffleboardController {
  public ShuffleboardTab preMatchTab = Shuffleboard.getTab("Pre-Match");
  public ShuffleboardTab autoTab = Shuffleboard.getTab("Auto");
  public ShuffleboardTab teleopTab = Shuffleboard.getTab("Teleop");
  public ShuffleboardTab testTab = Shuffleboard.getTab("Test");

  SendableChooser<Command> autoChooser = new SendableChooser<>();

  public ShuffleboardController() {
    // Pre-match
    autoChooser.setDefaultOption("Auto For Florida", new AutoForFlorida());
    autoChooser.setDefaultOption("Low Then High Target", new LowThenHighTarget());
    preMatchTab.add("Auto", autoChooser).withSize(2, 1);

    // Test
    testTab.add("Test", new TestCommand()).withSize(2, 1);
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
