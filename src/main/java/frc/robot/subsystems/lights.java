// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.CANdle;

public class lights extends SubsystemBase {
  private final CANdle leds = new CANdle(Constants.LEDS.ID);

  public void animate(Animation animationSelection){
    leds.animate(animationSelection);
  }
}
