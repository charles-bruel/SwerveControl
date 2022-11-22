// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveTest extends SubsystemBase {
  /** Creates a new SwerveTest. */
  public SwerveTest() {
    super();
    module = new SwerveModule(kSwerve1DriveCAN, kSwerve1SteerCAN, kSwerve1EncoderCAN, kSwerve1SteerOffset);
  }

  private SwerveModule module;
  private double target_steer;
  private double target_velocity;
  private int since_last_update = 0;

  public void set(double target_velocity, double target_steer) {
    this.target_steer = target_steer;
    this.target_velocity = target_velocity;
    since_last_update = 0;
  }

  @Override
  public void periodic() {
    since_last_update++;
    //Safety
    if(since_last_update > 10) {
      target_steer = 0;
      target_velocity = 0;
    }
    module.update(target_velocity, target_steer);
  }
}
