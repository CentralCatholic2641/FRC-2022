// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.IntakeCommand;
public class RobotContainer {
  public Joystick gamepad1 = new Joystick(0);
  public JoystickButton intakeButton = new JoystickButton(gamepad1, Constants.threeButton);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    intakeButton.whileHeld(new IntakeCommand());
  }
}