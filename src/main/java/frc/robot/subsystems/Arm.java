package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
//sub systems do define how to run (thinking) a chhange
public class Arm {
        TalonSRX armM;
        public Arm(){
                armM = new TalonSRX(Constants.AlgeArm.ArmMotorID);
        }
        public void Shoot(double percentOut){
                armM.set(TalonSRXControlMode.PercentOutput, -percentOut);
        }
}
