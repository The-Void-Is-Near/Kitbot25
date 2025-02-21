package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
//sub systems do define how to run (thinking) a chhange
public class Shooter {
        TalonSRX shooterM;
        public Shooter(){
                shooterM = new TalonSRX(Constants.Shooter.ShooterMotorID);
        }
        public void Shoot(double percentOut){
                shooterM.set(TalonSRXControlMode.PercentOutput, -percentOut);
        }
}
