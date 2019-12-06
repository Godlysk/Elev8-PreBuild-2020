/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Arm.VerticalMovement;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class CommandArmVertical extends Command {
  public CommandArmVertical() {
    requires(Robot.armVerticalSubsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    boolean ArmUpwards_Button = Robot.oi.joy1.getRawButton(Robot.joystick1.MoveUpButton);
    boolean ArmDownwards_Button = Robot.oi.joy1.getRawButton(Robot.joystick1.MoveDownButton);

    if(ArmUpwards_Button){Robot.armVerticalSubsystem.ArmVerticalMotor.set(0.6);}
    else if(ArmDownwards_Button){Robot.armVerticalSubsystem.ArmVerticalMotor.set(-0.6);}
    else{Robot.armVerticalSubsystem.ArmVerticalMotor.set(0);}
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
