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
  private final int thrustAxis = XboxController.Axis.kRightTrigger.value; //ID of Axis. (axis is analog)
  private final int reverseAxis = XboxController.Axis.kLeftTrigger.value;
  private final int steerAxisX = XboxController.Axis.kLeftX.value;
  private JoystickButton shooterButton = new JoystickButton(portedXboxController, XboxController.Button.kY.value);//Reads and sets to real value (BOOL)

  public Drivetrain drive = new Drivetrain();
  public Shooter shooter = new Shooter();

  // private final MotorController shooterM = new PWMVictorSPX(5);

  public RobotContainer() {
    // Configure the trigger bindings
    /*configureBindings();
    drive.setDefaultCommand(
        new TeleopDrive(drive,
        () -> Constants.MotorConstants.motorLimitK*(portedXboxController.getRawAxis(steerAxisX)),
        () -> Constants.MotorConstants.motorLimitK*(portedXboxController.getRawAxis(thrustAxis)-portedXboxController.getRawAxis(reverseAxis))));
    */
    configureBindings();
    drive.setDefaultCommand(
        new TeleopDrive(drive,
        () -> Constants.MotorConstants.motorLimitK*(portedXboxController.getRawAxis(steerAxisX)),
        () -> Constants.MotorConstants.motorLimitK*(portedXboxController.getRawAxis(reverseAxis)-portedXboxController.getRawAxis(thrustAxis))));//Flip Thrust
  }
 
  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
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
