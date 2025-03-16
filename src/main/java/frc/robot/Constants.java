
package frc.robot;
import java.util.Dictionary;
import java.util.Hashtable;

import com.ctre.phoenix.led.Animation;

import apple.laf.JRSUIConstants.Animating;
import edu.wpi.first.wpilibj.XboxController;

public final class Constants {
  public static class Controls {
    //Controller
    public static final int ControllerPort = 0;
    //Buttons
    public static final int thrust = XboxController.Axis.kRightTrigger.value;
    public static final int reverse = XboxController.Axis.kLeftTrigger.value;
    public static final int steer = XboxController.Axis.kRightX.value;
    public static final int shoot = XboxController.Button.kA.value;
    public static final int shootReverse = XboxController.Button.kY.value;
    public static final int deepclimb = XboxController.Button.kRightBumper.value;
    public static final int deepclimbReverse = XboxController.Button.kLeftBumper.value;
    //POV
    public static final int arm = 0;
    public static final int armReverse = 180;
  }

  public final class DriveBase{
    public static final double MotorSpeedLimit = 0.75;
  }

  public static class Shooter{
    public static final double ShootSpeedLimit = 1;
    public static final int ShooterMotorID = 6;
  }

  public static class AlgeArm{
    public static final int ArmMotorID = 5;
    public static final double ArmSpeedLimit = .25;
  }

  public static class DeepClimbConstants{
    public static final int ClimbMotorID = 61;
    public static final double climbSpeedLimit = .5;
  }
  public static class LEDS{
    public static final int ID = 0;
  }

}
