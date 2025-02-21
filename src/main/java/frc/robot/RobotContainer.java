package frc.robot;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TeleopShooter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final Joystick portedController = new Joystick(Constants.Controls.ControllerPort); 

  private final int thrustAxis = Constants.Controls.thrust;
  private final int reverseAxis = Constants.Controls.reverse;
  private final int steerAxisX = Constants.Controls.steer;

  private JoystickButton shooterButton = new JoystickButton(portedController, Constants.Controls.shoot);
  private JoystickButton shooterButtonReverse = new JoystickButton(portedController, Constants.Controls.shootReverse);

  public Drivetrain drive = new Drivetrain();
  public Shooter shooter = new Shooter();

  public RobotContainer() {
    configureBindings();
    drive.setDefaultCommand(
        new TeleopDrive(drive,
        () -> Constants.DriveBase.MotorSpeedLimit*(portedController.getRawAxis(steerAxisX)),
        () -> Constants.DriveBase.MotorSpeedLimit*(portedController.getRawAxis(thrustAxis)-portedController.getRawAxis(reverseAxis))));
  }
  
  private void configureBindings() {
    shooterButton.whileTrue(new TeleopShooter(shooter, Constants.Shooter.ShooterSpeedLimit));
    shooterButtonReverse.whileTrue(new TeleopShooter(shooter, -Constants.Shooter.ShooterSpeedLimit));
    shooterButton.onFalse(new TeleopShooter(shooter, 0.0));
    shooterButtonReverse.onFalse(new TeleopShooter(shooter, 0.0));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
