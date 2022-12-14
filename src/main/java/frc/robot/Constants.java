// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final double kSwerveDrive_K = 0;
    public static final double kSwerveDrive_P = 0;
    public static final double kSwerveDrive_I = 0;
    public static final double kSwerveDrive_D = 0;

    //For use on the falcon
    public static final double kSwerveSteer_K = 0;
    public static final double kSwerveSteer_P = 0;
    public static final double kSwerveSteer_I = 0;
    public static final double kSwerveSteer_D = 0;

    //For use controlling the falcon
    public static final double kSwerveSteerPrime_K = 0;
    public static final double kSwerveSteerPrime_P = 0;
    public static final double kSwerveSteerPrime_I = 0;
    public static final double kSwerveSteerPrime_D = 0;

    public static final double kDriveCurrentLimitPeak = 45;
    public static final double kDriveCurrentLimitContinuous = 40;
    public static final double kDriveCurrentLimitTime = 0.4;
    public static final double kDrivePowerRatioDuringAuto = 0.3;

    public static final int kPIDLoopIdx = 0;
    public static final int kTimeoutMs = 0;

    public static final int kLeftStickX = 0;
    public static final int kLeftStickY = 1;
    public static final int kRightStickX = 4;
    public static final int kRightStickY = 5;

    public static final double kRad2Deg = 180 / Math.PI;
    public static final double kDeg2Rad = 1 / kRad2Deg;

    //TODO: Populate these values
    public static final int kSwerve1SteerCAN = 0;
    public static final int kSwerve1DriveCAN = 0;
    public static final int kSwerve1EncoderCAN = 0;
    public static final double kSwerve1SteerOffset = 0;

    public static final int kSwerve2SteerCAN = 0;
    public static final int kSwerve2DriveCAN = 0;
    public static final int kSwerve2EncoderCAN = 0;
    public static final double kSwerve2SteerOffset = 0;

    public static final int kSwerve3SteerCAN = 0;
    public static final int kSwerve3DriveCAN = 0;
    public static final int kSwerve3EncoderCAN = 0;
    public static final double kSwerve3SteerOffset = 0;

    public static final int kSwerve4SteerCAN = 0;
    public static final int kSwerve4DriveCAN = 0;
    public static final int kSwerve4EncoderCAN = 0;
    public static final double kSwerve4SteerOffset = 0;

}
