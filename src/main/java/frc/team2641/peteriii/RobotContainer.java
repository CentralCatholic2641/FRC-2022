// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.peteriii;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.team2641.peteriii.commands.ClimberCommand;
import frc.team2641.peteriii.commands.DrivingCommand;
import frc.team2641.peteriii.commands.FireCommand;
import frc.team2641.peteriii.commands.HopperCommand;
import frc.team2641.peteriii.commands.IndexerCommand;
import frc.team2641.peteriii.commands.IntakeMotorCommand;
import frc.team2641.peteriii.commands.IntakePistonCommand;
import frc.team2641.peteriii.commands.ShooterCommand;
// import frc.team2641.peteriii.instants.ClimberLockInstant;
import frc.team2641.peteriii.subsystems.*;

public class RobotContainer {
  private final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  private final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  private final HopperSubsystem hopperSubsystem = new HopperSubsystem();

  // Gamepad
  public XboxController driver = new XboxController(Constants.Controllers.driver);
  public JoystickButton driverFireHighButton = new JoystickButton(driver,
      Constants.GamepadButtons.rightBumper);
  public JoystickButton driverFireLowButton = new JoystickButton(driver,
      Constants.GamepadButtons.yButton);

  // Joystick
  // public Joystick driver = new Joystick(Constants.Controllers.driver);
  // public JoystickButton driverFireHighButton = new JoystickButton(driver,
  // Constants.JoystickButtons.trigger);
  // public JoystickButton driverFireLowButton = new JoystickButton(driver,
  // Constants.JoystickButtons.thumb);

  public XboxController controller = new XboxController(Constants.Controllers.controller);
  public JoystickButton controllerFireButton = new JoystickButton(controller, Constants.GamepadButtons.rightBumper);
  public JoystickButton controllerIntakeButton = new JoystickButton(controller, Constants.GamepadButtons.aButton);
  public JoystickButton controllerHopperButton = new JoystickButton(controller, Constants.GamepadButtons.xButton);
  public JoystickButton controllerIndexerButton = new JoystickButton(controller, Constants.GamepadButtons.yButton);
  public JoystickButton controllerShooterButton = new JoystickButton(controller, Constants.GamepadButtons.bButton);
  public JoystickButton controllerFireLowButton = new JoystickButton(controller, Constants.GamepadButtons.startButton);

  public POVButton controllerClimberUpDpad = new POVButton(controller, 0);
  public POVButton controllerClimberDownDpad = new POVButton(controller, 180);
  public POVButton controllerIntakeToggle = new POVButton(controller, 90);
  // public POVButton controllerClimberLockToggle = new POVButton(controller,
  // 270);

  public boolean controllerShift = false;
  public boolean driverShift = false;

  public RobotContainer() {
    configureButtonBindings();

    drivingSubsystem.setDefaultCommand(new DrivingCommand(drivingSubsystem));
  }

  private void configureButtonBindings() {
    driverFireLowButton
        .whileHeld(new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 1));
    driverFireHighButton
        .whileHeld(new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 2));

    controllerIntakeButton.whileHeld(new IntakeMotorCommand(intakeSubsystem));
    controllerHopperButton.whileHeld(new HopperCommand(hopperSubsystem));
    controllerIndexerButton.whileHeld(new IndexerCommand(indexerSubsystem));
    controllerShooterButton.whileHeld(new ShooterCommand(shooterSubsystem, 2));
    controllerClimberUpDpad.whileHeld(new ClimberCommand(climberSubsystem, 1));
    controllerClimberDownDpad.whileHeld(new ClimberCommand(climberSubsystem, -1));
    controllerIntakeToggle.whileHeld(new IntakePistonCommand(intakeSubsystem));
    controllerFireLowButton
        .whileHeld(new FireCommand(intakeSubsystem, hopperSubsystem, indexerSubsystem, shooterSubsystem, 1));
  }
}