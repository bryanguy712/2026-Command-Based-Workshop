package frc.robot.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.ShooterSubsystem;

public class ShootCommand extends Command{
    private final ShooterSubsystem shooterSubsystem;

    public ShootCommand(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;

        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        shooterSubsystem.spinShooter();
    }
}
