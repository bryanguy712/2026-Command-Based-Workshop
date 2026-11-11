package frc.robot.subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    private final VictorSP leftDrive;
    private final VictorSP rightDrive;

    private DifferentialDrive drive;

    public DriveSubsystem() {
        leftDrive = new VictorSP(1);
        rightDrive = new VictorSP(0);

        rightDrive.setInverted(true);

        drive = new DifferentialDrive(leftDrive::set, rightDrive::set);
    }

    public void teleopDrive(double driveRequest, double turnRequest) {
        drive.arcadeDrive(driveRequest, turnRequest);
    }
}
