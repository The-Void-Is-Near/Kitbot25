// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  // Victor frontLeft;
  // Victor frontRight;
  // Victor backLeft;
  // Victor backRight;
  DifferentialDrive drive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    WPI_TalonSRX topLeftM = new WPI_TalonSRX(2);
    WPI_VictorSPX topRightM = new WPI_VictorSPX(1);
    WPI_VictorSPX bottomLeftM = new WPI_VictorSPX(3);
    WPI_VictorSPX bottomRightM = new WPI_VictorSPX(4);

    MotorControllerGroup leftMs = new MotorControllerGroup(topRightM, bottomRightM);
    MotorControllerGroup rightMs = new MotorControllerGroup(topLeftM, bottomLeftM);
    drive = new DifferentialDrive(leftMs, rightMs);
    }

  public void drive(double STEER, double SPEED) {
    drive.arcadeDrive(STEER, SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
