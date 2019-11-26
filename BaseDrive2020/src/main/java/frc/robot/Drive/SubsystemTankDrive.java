/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class SubsystemTankDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public WPI_TalonSRX FR;
  public WPI_TalonSRX BR;
  public WPI_TalonSRX FL;
  public WPI_TalonSRX BL;  


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new CommandDrive());
  }

  public SubsystemTankDrive() {
    FR = new WPI_TalonSRX(RobotMap.FR_port);
    BR = new WPI_TalonSRX(RobotMap.BR_port);
    FL = new WPI_TalonSRX(RobotMap.FL_port);
    BL = new WPI_TalonSRX(RobotMap.BL_port);  

    FR.setInverted(true);
    BR.setInverted(true);
  }

    
  public void drive(double leftSpeed, double rightSpeed) {
    FR.set(rightSpeed);
    BR.set(rightSpeed);
    FL.set(leftSpeed);
    BL.set(leftSpeed);
  }

  public void PID_Drive(double yaxis, double zaxis) {
    drive(0,0);

    //TODO: Implement this
  }

}
