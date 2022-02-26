// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

	// Joystick button profile
	// public static final int joystick1 = 1;
	// public static final int joystick2 = 2;
	// public static final int shooterSpeed = 3;
	// public static final int oneButton = 1;
	// public static final int twoButton = 2;
	// public static final int threeButton = 3;
	// public static final int fourButton = 4;
	// public static final int fiveButton = 5;

	// Xbox controller button profile
	public static final int lxAxis = 0;
	public static final int lyAxis = 1;
	public static final int leftTrigger = 2;
	public static final int rightTrigger = 3;
	public static final int rxAxis = 4;
	public static final int ryAxis = 5;
	public static final int aButton = 1;
	public static final int bButton = 2;
	public static final int xButton = 3;
	public static final int yButton = 4;
	public static final int leftBumper = 5;
	public static final int rightBumper = 6;
	public static final int backButton = 7;
	public static final int startButton = 8;

	// Controllers
	public static final int gamepad1 = 0;
	public static final int gamepad2 = 1;

	// Drivetrain motors
	public static final int leftMotor1 = 3;
	public static final int leftMotor2 = 4;
	public static final int leftMotor3 = 5;
	public static final int rightMotor1 = 0;
	public static final int rightMotor2 = 1;
	public static final int rightMotor3 = 2;
	public static final int climberMotor = 6;
	public static final int shooterMotor = 7;
	public static final int intakeMotor = 12;
	public static final int hopperMotor1 = 13;
	public static final int hopperMotor2 = 14;
	public static final int indexMotor = 15;

	// Encoders
	public static final int leftEncoder = 2;
	public static final int rightEncoder = 4;

	// PID-related
	public static final double kP = 0.8;
	public static final double kI = 0.00475;
	// public static final double kI = 0;
	// public static final double kD = 0.5;
	public static final double kD = 0.005;

	public static final double wheelDiameter = 0.5;
	public static final double driftCompensation = 0.04;
	public static final int oneRotation = 2048;
}