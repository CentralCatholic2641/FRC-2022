package frc.team2641.peteriii.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.peteriii.Constants;
// import edu.wpi.first.wpilibj.smartdashboard.Field2d;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.math.geometry.Pose2d;
// import edu.wpi.first.math.geometry.Rotation2d;
// import edu.wpi.first.math.kinematics.ChassisSpeeds;
// import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
// import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
// import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.util.Units;
import com.kauailabs.navx.frc.AHRS;

public class DrivingSubsystem extends SubsystemBase {
  public WPI_TalonFX leftMotor1 = new WPI_TalonFX(Constants.Motors.leftMotor1);
  public WPI_TalonFX leftMotor2 = new WPI_TalonFX(Constants.Motors.leftMotor2);
  public WPI_TalonFX leftMotor3 = new WPI_TalonFX(Constants.Motors.leftMotor3);

  public MotorControllerGroup leftGroup = new MotorControllerGroup(leftMotor1, leftMotor2, leftMotor3);

  public WPI_TalonFX rightMotor1 = new WPI_TalonFX(Constants.Motors.rightMotor1);
  public WPI_TalonFX rightMotor2 = new WPI_TalonFX(Constants.Motors.rightMotor2);
  public WPI_TalonFX rightMotor3 = new WPI_TalonFX(Constants.Motors.rightMotor3);

  public MotorControllerGroup rightGroup = new MotorControllerGroup(rightMotor1, rightMotor2, rightMotor3);

  public WPI_TalonFX leftEncoder = new WPI_TalonFX(Constants.leftEncoder);
  public WPI_TalonFX rightEncoder = new WPI_TalonFX(Constants.rightEncoder);

  public DifferentialDrive differentialDrive = new DifferentialDrive(leftGroup, rightGroup);

  public AHRS ahrs;

  // Field2d field = new Field2d();

  public DrivingSubsystem() {
    ahrs = new AHRS();
    ahrs.zeroYaw();

    leftMotor1.clearStickyFaults();
    leftMotor2.clearStickyFaults();
    leftMotor3.clearStickyFaults();
    rightMotor1.clearStickyFaults();
    rightMotor2.clearStickyFaults();
    rightMotor3.clearStickyFaults();

    // SmartDashboard.putData("Field", field);
    // differentialDrive.setMaxOutput(Constants.MotorSpeeds.maxDrive);
    configBrakes(Constants.MotorSpeeds.brakes);
    configRamps(Constants.MotorSpeeds.driveRampSpeed);
  }

  public void aDrive(double rotation, double speed) {
    differentialDrive.arcadeDrive(rotation, speed, true);
  }

  public void tDrive(double left, double right) {
    differentialDrive.tankDrive(-left, -right, true);
  }

  // public double encoderDistance(String whichEncoder) {
  public double getDistance() {
    // if (whichEncoder == "left") {
    return (double) (leftEncoder.getSelectedSensorPosition() /
        Constants.oneRotation) * (Math.PI * Units.feetToMeters(Constants.wheelDiameter)) / 10.71;
    // } else {
    // return (double) (rightEncoder.getSelectedSensorPosition() /
    // Constants.oneRotation)
    // * (Math.PI * Units.feetToMeters(Constants.wheelDiameter));
    // }
  }

  public void halt() {
    configRamps(Constants.MotorSpeeds.driveRampSpeed);
    configBrakes(Constants.MotorSpeeds.brakes);
    leftMotor1.stopMotor();
    leftMotor2.stopMotor();
    leftMotor3.stopMotor();
    rightMotor1.stopMotor();
    rightMotor2.stopMotor();
    rightMotor3.stopMotor();
  }

  public void configBrakes(boolean brakesOn) {
    NeutralMode input;
    if (brakesOn)
      input = NeutralMode.Brake;
    else
      input = NeutralMode.Coast;

    leftMotor1.setNeutralMode(input);
    leftMotor2.setNeutralMode(input);
    leftMotor3.setNeutralMode(input);
    rightMotor1.setNeutralMode(input);
    rightMotor2.setNeutralMode(input);
    rightMotor3.setNeutralMode(input);
  }

  public void configRamps(double driveRampSpeed) {
    leftMotor1.configOpenloopRamp(driveRampSpeed);
    leftMotor2.configOpenloopRamp(driveRampSpeed);
    leftMotor3.configOpenloopRamp(driveRampSpeed);
    rightMotor1.configOpenloopRamp(driveRampSpeed);
    rightMotor2.configOpenloopRamp(driveRampSpeed);
    rightMotor3.configOpenloopRamp(driveRampSpeed);
  }

  public void resetEncoder() {
    rightEncoder.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {

    // DifferentialDriveKinematics kinematics = new
    // DifferentialDriveKinematics(Units.inchesToMeters(27.0));

    // ChassisSpeeds chassisSpeeds = new ChassisSpeeds(ahrs.getVelocityY(), 0,
    // Units.degreesToRadians(ahrs.getRate()));

    // DifferentialDriveWheelSpeeds wheelSpeeds =
    // kinematics.toWheelSpeeds(chassisSpeeds);

    // double leftVelocity = wheelSpeeds.leftMetersPerSecond;
    // double rightVelocity = wheelSpeeds.rightMetersPerSecond;

    // DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(
    // ahrs.getRotation2d(), new Pose2d(1, 1, new Rotation2d()));

    // Rotation2d gyroAngle = Rotation2d.fromDegrees(-ahrs.getAngle() % 360);

    // Pose2d pose = odometry.update(gyroAngle, getDistance(),
    // getDistance());

    // field.setRobotPose(pose);
  }
}