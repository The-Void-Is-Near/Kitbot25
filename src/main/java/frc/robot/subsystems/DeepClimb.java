package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;

public class DeepClimb {
        //Declare Motor Type
        VictorSPX climbM;

        //Declare Motor Value With ID
        public DeepClimb(){
                climbM = new VictorSPX(Constants.DeepClimbConstants.ClimbMotorID);
        }
        
        //Move Motor  
        public void Shoot(double percentOut){
                climbM.set(VictorSPXControlMode.PercentOutput, -percentOut);
        }
}
