package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;
//sub systems do define how to run (thinking) a chhange
public class DeepClimb {
        VictorSPX climbM;
        public DeepClimb(){
                climbM = new VictorSPX(Constants.DeepClimb.ClimbMotorID);
        }
        public void Shoot(double percentOut){
                climbM.set(VictorSPXControlMode.PercentOutput, -percentOut);
        }
}
