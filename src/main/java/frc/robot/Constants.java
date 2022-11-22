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

}
