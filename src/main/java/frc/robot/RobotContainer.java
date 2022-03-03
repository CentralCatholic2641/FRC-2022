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
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;

public class RobotContainer {

  // int driverDirection = 1;
  int controllerDirection = 1;

  public XboxController driver = new XboxController(Constants.controller1);
  public JoystickButton driverFireButton = new JoystickButton(driver, Constants.rightBumper);

  public XboxController controller = new XboxController(Constants.controller2);
  public JoystickButton controllerFireButton = new JoystickButton(controller, Constants.rightBumper);
  public JoystickButton controllerIntakeButton = new JoystickButton(controller, Constants.aButton);
  public JoystickButton controllerHopperButton = new JoystickButton(controller, Constants.xButton);
  public JoystickButton controllerIndexerButton = new JoystickButton(controller, Constants.yButton);
  public JoystickButton controllerShooterButton = new JoystickButton(controller, Constants.bButton);

  public POVButton controllerClimberUpDpad = new POVButton(controller, 0);
  public POVButton controllerClimberDownDpad = new POVButton(controller, 180);
  public POVButton controllerIntakeDownDpad = new POVButton(controller, 90);
  public POVButton controllerIntakeUpDpad = new POVButton(controller, 270);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    if (controller.getRawButton(Constants.leftBumper)) {
      controllerDirection = -1;
    } else {
      controllerDirection = 1;
    }

    controllerFireButton.whileHeld(new FireCommand(1));
    controllerIntakeButton.whileHeld(new IntakeCommand(controllerDirection));
    controllerHopperButton.whileHeld(new HopperCommand(controllerDirection));
    controllerIndexerButton.whileHeld(new IndexerCommand(controllerDirection));
    controllerShooterButton.whileHeld(new ShooterCommand(controllerDirection));
    controllerClimberUpDpad.whileHeld(new ClimberCommand(1));
    controllerClimberDownDpad.whileHeld(new ClimberCommand(-1));
    controllerIntakeUpDpad.whileHeld(new IntakeCommand(2));
    controllerIntakeDownDpad.whileHeld(new IntakeCommand(-2));

    driverFireButton.whileHeld(new FireCommand(1));
  }
}