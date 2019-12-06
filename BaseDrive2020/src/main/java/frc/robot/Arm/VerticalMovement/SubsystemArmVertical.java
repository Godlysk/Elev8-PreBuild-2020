/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Arm.VerticalMovement;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;

public class SubsystemArmVertical extends Subsystem {

  public WPI_TalonSRX ArmVerticalMotor;
  public Encoder encArmVertical;

  public SubsystemArmVertical() {
    ArmVerticalMotor = new WPI_TalonSRX (RobotMap.ArmVertical_port);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CommandArmVertical());
  }
}
