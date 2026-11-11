package frc.robot.command;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.DriveSubsystem;

public class TeleopDriveCommand extends Command{
    private final DriveSubsystem driveSubsystem;
    private final XboxController controller;

    public TeleopDriveCommand(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;

        controller = new XboxController(0);

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.teleopDrive(controller.getLeftY(), controller.getRightX());
    }
}
