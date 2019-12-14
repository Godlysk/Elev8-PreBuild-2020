/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Arm;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SubsystemArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  VictorSP armMotor;

  public SubsystemArm() { 
    //armMotor = new VictorSP(0);  //Connection to PWM port 0
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new CommandArm());
  }

  public void move(double speed) {
    armMotor.set(speed);
  }

}
