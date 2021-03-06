/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;

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




  
  double integral_DriveStraight = 0;

  public void PID_DriveStraight(double yaxis) {
    
    double navxYawAxisRate = Robot.oi.navx.getRate();
    double shaftLeftRate = Robot.oi.enc_L.getRate();
    double shaftRightRate = Robot.oi.enc_R.getRate();

    SmartDashboard.putNumber("Yaw Rate", navxYawAxisRate);
    SmartDashboard.putNumber("Left Encoder Rate", shaftLeftRate);
    SmartDashboard.putNumber("Right Encoder Rate", shaftRightRate);

    double error = shaftLeftRate - shaftRightRate;
    integral_DriveStraight += error;
    double derivative = navxYawAxisRate; 

    double correction = (error * RobotSettings.kP_DriveStraight);
    correction += (integral_DriveStraight * RobotSettings.kI_DriveStraight);
    correction += (derivative * RobotSettings.kD_DriveStraight);

    double left = yaxis - correction;
    double right = yaxis + correction;

    drive(left*RobotSettings.maxSpeed, right*RobotSettings.maxSpeed);

  }





  double integral_PointTurn = 0;

  public void PID_PointTurn(double zaxis) {
    
    double navxYawAxisRate = Robot.oi.navx.getRate();
    double shaftLeftRate = Robot.oi.enc_L.getRate();
    double shaftRightRate = Robot.oi.enc_R.getRate();

    SmartDashboard.putNumber("Yaw Rate", navxYawAxisRate);
    SmartDashboard.putNumber("Left Encoder Rate", shaftLeftRate);
    SmartDashboard.putNumber("Right Encoder Rate", shaftRightRate);
    
    double error = shaftLeftRate + shaftRightRate;
    integral_PointTurn += error;
    double derivative = navxYawAxisRate; 

    double correction = (error * RobotSettings.kP_PointTurn);
    correction += (integral_PointTurn * RobotSettings.kI_PointTurn);
    correction += (derivative * RobotSettings.kD_PointTurn);

    double left = (zaxis + correction);
    double right = -1 * (zaxis - correction);

    drive(left*RobotSettings.maxSpeed, right*RobotSettings.maxSpeed);

  }





  public void PID_SteerDrive(double yaxis, double zaxis) {
    
    //double navxYawAxisRate = Robot.oi.navx.getRate();
    //SmartDashboard.putNumber("Yaw Rate", navxYawAxisRate);

    double error = zaxis*RobotSettings.swerveCoefficient;  
    double correction = error; 
   
    double left = yaxis + correction;
    double right = yaxis - correction;
    drive(left*RobotSettings.maxSpeed, right*RobotSettings.maxSpeed);
    
  }





  // NAV-X only PID (Not tested)

  public void PID_DriveStraight_NavX(double yaxis) {

    double navxYawAxisRate = Robot.oi.navx.getRate();
    SmartDashboard.putNumber("Yaw Rate", navxYawAxisRate);
    double error = navxYawAxisRate;

    double correction = (error * RobotSettings.kP_DriveStraight);

    double left = yaxis - correction;
    double right = yaxis + correction;

    drive(left*RobotSettings.maxSpeed, right*RobotSettings.maxSpeed);

  }






  public void PID_PointTurn_NavX(double zaxis) {
    
    double navxYawAxisRate = Robot.oi.navx.getRate();

    SmartDashboard.putNumber("Yaw Rate", navxYawAxisRate);

    double error = zaxis - (navxYawAxisRate*RobotSettings.yawRateConst);
    double correction = (error * RobotSettings.kP_PointTurn);

    double left = (zaxis + correction);
    double right = -1 * (zaxis - correction);

    drive(left*RobotSettings.maxSpeed, right*RobotSettings.maxSpeed);

  }


}
