package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;

public class Arm {
        //Declare Motor Type
        VictorSPX armM;

        //Declare Motor Value With ID
        public Arm(){
                armM = new VictorSPX(Constants.AlgeArm.ArmMotorID);
        }

        //Move Motor
        public void Shoot(double percentOut){
                armM.set(VictorSPXControlMode.PercentOutput, -percentOut);
        }
}
