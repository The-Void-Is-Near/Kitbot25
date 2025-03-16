package frc.robot;//save
import frc.robot.commands.TeleopArm;
import frc.robot.commands.TeleopDeepClimb;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TeleopShooter;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DeepClimb;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class RobotContainer {
  //Defines 1 Controller
  private final Joystick portedController = new Joystick(Constants.Controls.ControllerPort); 
  //Sets Button IDs
  private final int thrustAxis = Constants.Controls.thrust;
  private final int reverseAxis = Constants.Controls.reverse;
  private final int steerAxisX = Constants.Controls.steer;
  //Defines Shooter Buttons
  private JoystickButton shooterButton = new JoystickButton(portedController, Constants.Controls.shoot);
  private JoystickButton shooterButtonReverse = new JoystickButton(portedController, Constants.Controls.shootReverse);
  //Defines Arm Buttons
  private POVButton armButtom = new POVButton(portedController, Constants.Controls.arm);
  private POVButton armButtomReverse = new POVButton(portedController, Constants.Controls.armReverse);
  //Defines Climb Buttons
  private JoystickButton climbButton = new JoystickButton(portedController, Constants.Controls.deepclimb);
  private JoystickButton climbButtonReverse = new JoystickButton(portedController, Constants.Controls.deepclimbReverse);

  //Subsystems: 
  public Drivetrain drive = new Drivetrain();
  public Shooter shooter = new Shooter();
  public Arm arm = new Arm(); 
  public DeepClimb climb = new DeepClimb();

  //Run Drivebase
  public RobotContainer() {
    configureBindings();
    drive.setDefaultCommand(
        new TeleopDrive(drive,
        () -> Constants.DriveBase.MotorSpeedLimit*(portedController.getRawAxis(steerAxisX)),
        () -> Constants.DriveBase.MotorSpeedLimit*(portedController.getRawAxis(thrustAxis)-portedController.getRawAxis(reverseAxis))));
  } 

  private void configureBindings() {
    //Set Shooter Buttons
    shooterButton.whileTrue(new TeleopShooter(shooter, Constants.Shooter.ShootSpeedLimit));
    shooterButtonReverse.whileTrue(new TeleopShooter(shooter, -Constants.Shooter.ShootSpeedLimit));
    shooterButton.onFalse(new TeleopShooter(shooter, 0.0));
    shooterButtonReverse.onFalse(new TeleopShooter(shooter, 0.0));
    //Set Arm Buttons
    armButtom.whileTrue(new TeleopArm(arm, Constants.AlgeArm.ArmSpeedLimit));
    armButtomReverse.whileTrue(new TeleopArm(arm, -Constants.AlgeArm.ArmSpeedLimit));
    armButtom.onFalse(new TeleopArm(arm, 0.0));
    armButtomReverse.onFalse(new TeleopArm(arm, 0.0));
    //Set Climb Buttons
    climbButton.whileTrue(new TeleopDeepClimb(climb, Constants.DeepClimbConstants.climbSpeedLimit));
    climbButtonReverse.whileTrue(new TeleopDeepClimb(climb, -Constants.DeepClimbConstants.climbSpeedLimit));
    climbButton.onFalse(new TeleopDeepClimb(climb, 0.0));
    climbButtonReverse.onFalse(new TeleopDeepClimb(climb, 0.0));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
