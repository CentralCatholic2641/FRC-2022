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
	public static final int threeButton = 3;
	public static final int fourButton = 4;
	public static final int fiveButton = 5;

	// Controllers
	public static final int gamepad1 = 0;
	public static final int gamepad2 = 1;

	// Drivetrain motors
	public static final int leftmotor1 = 3;
	public static final int leftmotor2 = 4;
	public static final int leftmotor3 = 5;
	public static final int rightmotor1 = 0;
	public static final int rightmotor2 = 1;
	public static final int rightmotor3 = 2;
	public static final int climberMotor = 6;
	public static final int indexMotor1 = 10;
	public static final int indexmotor2 = 9;
	public static final int shooterMotor = 7;
	public static final int intakemotor1 = 8;

	public static double indexerSpeed = 0.6;

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