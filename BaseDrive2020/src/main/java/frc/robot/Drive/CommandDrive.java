/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotSettings;

public class CommandDrive extends Command {
  public CommandDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.tankDriveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double yaxis = Robot.oi.getY(Robot.oi.joy1, RobotSettings.yDeadband); //Adjusted Y
    double zaxis = Robot.oi.getZ(Robot.oi.joy1, RobotSettings.zDeadband); // Adjusted Z

    SmartDashboard.putNumber("Y-AXIS", yaxis);
    SmartDashboard.putNumber("Z-AXIS", zaxis);
    
    if (Math.abs(zaxis) > RobotSettings.zTurnThreshold) {
      Robot.tankDriveSubsystem.PID_PointTurn(zaxis);
    } else {
      if (yaxis != 0) Robot.tankDriveSubsystem.PID_DriveStraight(yaxis);
      else Robot.tankDriveSubsystem.drive(0, 0);
    }
    
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
