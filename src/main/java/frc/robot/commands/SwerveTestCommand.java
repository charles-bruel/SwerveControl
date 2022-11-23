// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SwerveTestCommand extends CommandBase {
  /** Creates a new SwerveTestCommand. */
  public SwerveTestCommand() {
    addRequirements(RobotContainer.test);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = RobotContainer.controller.getAxisType(kLeftStickX);
    double y = RobotContainer.controller.getAxisType(kLeftStickY);

    //Driving magnitude is often squared for control reasons
    //It also saves some math
    double sqrMagnitude = x * x + y * y;

    double angle = Math.atan2(y, x);//In radians
    angle *= kRad2Deg;

    RobotContainer.test.set(sqrMagnitude, angle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
