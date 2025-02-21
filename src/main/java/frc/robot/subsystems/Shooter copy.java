package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
//sub systems do define how to run (thinking) a chhange
public class arm {
        TalonSRX armM;
        public arm(){
                armM = new TalonSRX(Constants.MotorConstants.ArmShooterMid);
        }
        public void Shoot(double percentOut){
                shooterM.set(TalonSRXControlMode.PercentOutput, -percentOut);
        }
}
