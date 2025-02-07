package frc.robot;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TeleopShooter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
//Don't add to Robot.java, Put the structure of the robot (including subsystems, commands, and trigger mappings) HERE.

public class RobotContainer {
  private final Joystick portedXboxController = new Joystick(0); //Set USB Port.
  private final int thrustAxis = XboxController.Axis.kRightTrigger.value; //ID of Axis. (axis is analog, but this is not data)
  private final int reverseAxis = XboxController.Axis.kLeftTrigger.value;
  private final int steerAxisX = XboxController.Axis.kLeftX.value;
  private JoystickButton shooterButton = new JoystickButton(portedXboxController, XboxController.Button.kY.value);//Reads and sets to real value (BOOL) via the ID.

  public Drivetrain drive = new Drivetrain();//Used class in subsystem and creates an object.
  public Shooter shooter = new Shooter();// The COMMANDS call the SUBSYSTEM

  public RobotContainer() {
    configureBindings();//Defines controls (Xbox)
    drive.setDefaultCommand(
        new TeleopDrive(drive,
        () -> Constants.MotorConstants.motorLimitK*(portedXboxController.getRawAxis(steerAxisX)),
        () -> Constants.MotorConstants.motorLimitK*(portedXboxController.getRawAxis(reverseAxis)-portedXboxController.getRawAxis(thrustAxis))));//Flip Thrust
  }
 
  private void configureBindings() {
    shooterButton.whileTrue(new TeleopShooter(shooter, Constants.MotorConstants.shooterK));
    shooterButton.whileFalse(new TeleopShooter(shooter, 0.0));
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    // .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
