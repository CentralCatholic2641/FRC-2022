// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

import frc.robot.commands.ClimberCommand;
import frc.robot.commands.FireCommand;
import frc.robot.commands.HopperCommand;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.IntakeMotorCommand;
import frc.robot.commands.IntakePistonCommand;
import frc.robot.commands.ShooterCommand;

import frc.robot.instants.ClimberLockInstant;

public class RobotContainer {

  public XboxController driver = new XboxController(Constants.controller1);
  public JoystickButton driverFireLowButton = new JoystickButton(driver, Constants.rightBumper);
  public JoystickButton driverFireHighButton = new JoystickButton(driver, Constants.yButton);
  public JoystickButton driverLockClimber = new JoystickButton(driver, Constants.aButton);

  public XboxController controller = new XboxController(Constants.controller2);
  public JoystickButton controllerFireButton = new JoystickButton(controller, Constants.rightBumper);
  public JoystickButton controllerIntakeButton = new JoystickButton(controller, Constants.aButton);
  public JoystickButton controllerHopperButton = new JoystickButton(controller, Constants.xButton);
  public JoystickButton controllerIndexerButton = new JoystickButton(controller, Constants.yButton);
  public JoystickButton controllerShooterButton = new JoystickButton(controller, Constants.bButton);

  public POVButton controllerClimberUpDpad = new POVButton(controller, 0);
  public POVButton controllerClimberDownDpad = new POVButton(controller, 180);
  public POVButton controllerIntakeToggle = new POVButton(controller, 90);
  public POVButton controllerClimberLockToggle = new POVButton(controller, 270);

  public boolean controllerShift = false;
  public boolean driverShift = false;

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    driverFireLowButton.whileHeld(new FireCommand(1));
    driverFireHighButton.whileHeld(new FireCommand(2));

    controllerIntakeButton.whileHeld(new IntakeMotorCommand());
    controllerHopperButton.whileHeld(new HopperCommand());
    controllerIndexerButton.whileHeld(new IndexerCommand());
    controllerShooterButton.whileHeld(new ShooterCommand(1, false));
    controllerClimberUpDpad.whileHeld(new ClimberCommand(1));
    controllerClimberDownDpad.whileHeld(new ClimberCommand(-1));
    controllerIntakeToggle.whileHeld(new IntakePistonCommand());
    controllerClimberLockToggle.whenPressed(new ClimberLockInstant());
  }
}