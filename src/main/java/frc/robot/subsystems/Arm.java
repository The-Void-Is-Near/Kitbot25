package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;
//sub systems do define how to run (thinking) a chhange
public class Arm {
        VictorSPX armM;
        public Arm(){
                armM = new VictorSPX(Constants.AlgeArm.ArmMotorID);
        }
        public void Shoot(double percentOut){
                armM.set(VictorSPXControlMode.PercentOutput, -percentOut);
        }
}
