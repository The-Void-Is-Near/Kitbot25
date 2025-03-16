package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class Shooter {
        //Declare Motor Type
        TalonSRX shooterM;

        //Declare Motor Value With ID
        public Shooter(){
                shooterM = new TalonSRX(Constants.Shooter.ShooterMotorID);
        }

        //Move Motor
        public void Shoot(double percentOut){
                shooterM.set(TalonSRXControlMode.PercentOutput, -percentOut);
        }
}
