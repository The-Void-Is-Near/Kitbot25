// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DeepClimb;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TeleopDeepClimb extends Command {
  /** Creates a new TeleopShooter. */
  DeepClimb deepclimb;
  double PercentOutSup;
  public TeleopDeepClimb(DeepClimb deepclimb, double PercentOutSup) {
    this.deepclimb = deepclimb;
    this.PercentOutSup = PercentOutSup;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    deepclimb.Shoot(PercentOutSup);
  }

  // Called once the command ends or is inte{rrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
