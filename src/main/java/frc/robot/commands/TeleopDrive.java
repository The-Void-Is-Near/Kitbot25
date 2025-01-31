// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.function.DoubleSupplier;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;


/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TeleopDrive extends Command {
  Drivetrain drive;
  DoubleSupplier xSpeedSup;
  DoubleSupplier ySpeedSup;
  DoubleSupplier rotSup;
  /** Creates a new TeleopDrive. */
  public TeleopDrive(Drivetrain drive, DoubleSupplier xSpeedSup, DoubleSupplier ySpeedSup) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    this.xSpeedSup = xSpeedSup;
    this.ySpeedSup = ySpeedSup;
    addRequirements(drive);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xSpeedVal = MathUtil.applyDeadband(xSpeedSup.getAsDouble(), 0.1);
    double ySpeedVal = MathUtil.applyDeadband(ySpeedSup.getAsDouble(), 0.1);
    drive.drive(xSpeedVal, ySpeedVal);
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
