package frc.robot;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TeleopShooter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//Don't add to Robot.java, Put the structure of the robot (including subsystems, commands, and trigger mappings) HERE.
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class RobotContainer {
  private final Joystick portedController = new Joystick(0); //Set USB Port.
  private final int thrustAxis = XboxController.Axis.kRightTrigger.value; //ID of Axis. (axis is analog, but this is not data)
  private final int reverseAxis = XboxController.Axis.kLeftTrigger.value;
  private final int steerAxisX = XboxController.Axis.kRightX.value;
  private JoystickButton shooterButton = new JoystickButton(portedController, XboxController.Button.kY.value);//Reads and sets to real value (BOOL) via the ID.
  private JoystickButton shooterButtonReverse = new JoystickButton(portedController, XboxController.Button.kA.value);//Reads and sets to real value (BOOL) via the ID.
  
  private POVButton algearmButton = new POVButton(portedController, 0);//Reads and sets to real value (BOOL) via the ID.

  public Drivetrain drive = new Drivetrain();//Used class in subsystem and creates an object.
  public Shooter shooter = new Shooter();// The COMMANDS call the SUBSYSTEM
  public Shooter algearm = new //Shooter();

  public RobotContainer() {
    configureBindings();//Defines controls (Xbox)
    drive.setDefaultCommand(
        new TeleopDrive(drive,
        () -> Constants.MotorConstants.motorLimitK*(portedController.getRawAxis(steerAxisX)),
        () -> Constants.MotorConstants.motorLimitK*(portedController.getRawAxis(reverseAxis)-portedController.getRawAxis(thrustAxis))));//Flip Thrust
  }
  
  private void configureBindings() {
    shooterButton.whileTrue(new TeleopShooter(shooter, Constants.MotorConstants.shooterK));
    shooterButtonReverse.whileTrue(new TeleopShooter(shooter, -Constants.MotorConstants.shooterK));
    shooterButton.onFalse(new TeleopShooter(shooter, 0.0));
    shooterButtonReverse.onFalse(new TeleopShooter(shooter, 0.0));

    algearmButton.whileTrue(new TeleopShooter(algearm, 1.0));
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
