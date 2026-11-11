package frc.robot.subsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    private final SparkMax shooterFlywheel;

    public ShooterSubsystem() {
        shooterFlywheel = new SparkMax(7, MotorType.kBrushless);
    }

    public void spinShooter() {
        shooterFlywheel.setVoltage(4);
    }

    public void stopShooter() {
        shooterFlywheel.stopMotor();
    }
}
