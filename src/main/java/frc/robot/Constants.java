
package frc.robot;
import edu.wpi.first.wpilibj.XboxController;

public final class Constants {
  public static class Controls {
    public static final int ControllerPort = 0;
    public static final int thrust = XboxController.Axis.kRightTrigger.value;
    public static final int reverse = XboxController.Axis.kLeftTrigger.value;
    public static final int steer = XboxController.Axis.kRightX.value;
    public static final int shoot = XboxController.Button.kY.value;
    public static final int shootReverse = XboxController.Button.kA.value;
    public static final int arm = 0;
    public static final int armReverse = 180;
  }
public final class DriveBase{
  public static final double MotorSpeedLimit = 0.75;

}
  public static class Shooter{
    public static final double ShooterSpeedLimit = 1;
    public static final int ShooterMotorID = 6;
  }

  public static class AlgeArm{
    public static final int ArmMotorID = 5;
    public static final double ArmSpeedLimit = .75;

  }
}
 