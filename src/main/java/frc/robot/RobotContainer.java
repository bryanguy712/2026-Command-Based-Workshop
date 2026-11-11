// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.command.ShootCommand;
import frc.robot.command.TeleopDriveCommand;
import frc.robot.subsystem.DriveSubsystem;
import frc.robot.subsystem.ShooterSubsystem;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final TeleopDriveCommand TeleopDriveCommand = new TeleopDriveCommand(driveSubsystem);

  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ShootCommand shootCommand = new ShootCommand(shooterSubsystem);

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(TeleopDriveCommand);
    shooterSubsystem.setDefaultCommand(shootCommand);

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
