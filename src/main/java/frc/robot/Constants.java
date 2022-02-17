// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

	// Joysticks
	public static final int joystick1 = 1;
	public static final int joystick2 = 2;
	public static final int shooterSpeed = 3;

	// Joystick controller
	public static final int oneButton = 1;
	public static final int twoButton = 2;
	public static final int threeButton = 3; // intake
	public static final int fourButton = 4;
	public static final int fiveButton = 5;

	// Controllers
	public static final int gamepad1 = 0;
	public static final int gamepad2 = 1;

	// Drivetrain motors
	public static final int leftmotor1 = 0;
	public static final int leftmotor2 = 1;
	public static final int leftmotor3 = 2;
	public static final int rightmotor1 = 3;
	public static final int rightmotor2 = 4;
	public static final int rightmotor3 = 5;

	// Miscellaneous motors
	public static final int shooterMotor = 4;
	public static final int intakemotor1 = 6;

	// Encoders
	public static final int leftEncoder = 2;
	public static final int rightEncoder = 4;

	// PID-related
	public static final double kP = 0.6;
	public static final double kI = 0.002;
	public static final double kD = 0.2;
	public static final double wheelDiameter = 0.5;
	public static final double driftCompensation = 0.04;
	public static final int oneRotation = 4096;

	// For the indexer -- Needs changed
	public static int indexMotor1 = 1;
	public static int indexmotor2 = 2;
	public static double indexerSpeed = 0.6;
}