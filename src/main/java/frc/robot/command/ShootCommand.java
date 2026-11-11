package frc.robot.command;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.ShooterSubsystem;

public class ShootCommand extends Command{
    private final ShooterSubsystem shooterSubsystem;
    private final XboxController controller;    

    public ShootCommand(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;

        controller = new XboxController(0);

        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        if(controller.getRightBumperButton()) {
            shooterSubsystem.spinShooter();
        } else {
            shooterSubsystem.stopShooter();
        }
    }
}
