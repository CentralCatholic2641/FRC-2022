// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
  
public class RobotContainer {
  public Joystick gamepad1 = new Joystick(Constants.gamepad2);
  public JoystickButton intakeButton = new JoystickButton(gamepad1, Constants.threeButton);
  public JoystickButton highButton = new JoystickButton(gamepad1, Constants.oneButton);
  public JoystickButton lowButton = new JoystickButton(gamepad1, Constants.twoButton);
  public JoystickButton indexerButton1 = new JoystickButton(gamepad1, Constants.fourButton);
  public JoystickButton indexerButton2 = new JoystickButton(gamepad1, Constants.fiveButton);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    indexerButton1.whileHeld(new IndexerCommand(true));
    indexerButton2.whileHeld(new IndexerCommand(false));
    intakeButton.whileHeld(new IntakeCommand());
    highButton.whileHeld(new ShooterCommand(1));
    lowButton.whileHeld(new ShooterCommand(0));
  }
}