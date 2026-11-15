// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.command.ShootCommand;
import frc.robot.command.TeleopDriveCommand;
import frc.robot.subsystem.DriveSubsystem;
import frc.robot.subsystem.ShooterSubsystem;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final TeleopDriveCommand TeleopDriveCommand = new TeleopDriveCommand(driveSubsystem);

  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final Command idleShooter = shooterSubsystem.run(shooterSubsystem::stopShooter);

  private final XboxController controller = new XboxController(0);
  private Trigger shootTrigger;

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(TeleopDriveCommand);
    shooterSubsystem.setDefaultCommand(idleShooter);

    configureBindings();
  }

  private void configureBindings() {
    shootTrigger = new Trigger(() -> controller.getRightBumperButton());
    shootTrigger.whileTrue(new ShootCommand(shooterSubsystem));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
