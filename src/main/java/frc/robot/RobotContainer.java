// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimberCommand;
import frc.robot.commands.HopperCommand;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.IntakeCommand;
// import frc.robot.commands.ShooterCommand;

public class RobotContainer {
  public Joystick gamepad1 = new Joystick(Constants.gamepad1);
  public JoystickButton intakeForwardButton = new JoystickButton(gamepad1, Constants.leftBumper);
  public JoystickButton intakeBackwardButton = new JoystickButton(gamepad1, Constants.backButton);
  public JoystickButton intakeRaiseButton = new JoystickButton(gamepad1, Constants.xButton);
  public JoystickButton intakeLowerButton = new JoystickButton(gamepad1, Constants.bButton);
  public JoystickButton hopperForwardButton = new JoystickButton(gamepad1, Constants.rightBumper);
  // public JoystickButton hopperBackwardButton = new JoystickButton(gamepad1,
  // Constants.startButton);
  // public JoystickButton highButton = new JoystickButton(gamepad1,
  // Constants.rightBumper);
  // public JoystickButton lowButton = new JoystickButton(gamepad1,
  // Constants.leftBumper);
  public JoystickButton climbUpButton = new JoystickButton(gamepad1, Constants.yButton);
  public JoystickButton climbDownButton = new JoystickButton(gamepad1, Constants.aButton);
  public JoystickButton indexerForwardButton = new JoystickButton(gamepad1,
      Constants.startButton);
  // public JoystickButton indexerBackwardButton = new JoystickButton(gamepad1,
  // Constants.bButton);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    indexerForwardButton.whileHeld(new IndexerCommand(1));
    // indexerBackwardButton.whileHeld(new IndexerCommand(-1));
    intakeLowerButton.whileHeld(new IntakeCommand(-2));
    intakeRaiseButton.whileHeld(new IntakeCommand(2));
    intakeForwardButton.whileHeld(new IntakeCommand(1));
    intakeBackwardButton.whileHeld(new IntakeCommand(-1));
    hopperForwardButton.whileHeld(new HopperCommand(1));
    // hopperBackwardButton.whileHeld(new HopperCommand(-1));
    // highButton.whileHeld(new ShooterCommand(1));
    // lowButton.whileHeld(new ShooterCommand(0));
    climbUpButton.whileHeld(new ClimberCommand(1));
    climbDownButton.whileHeld(new ClimberCommand(-1));
  }
}