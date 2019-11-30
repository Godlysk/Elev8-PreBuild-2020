/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class RobotSettings {

    public final static double yDeadband = 0.1;
    public final static double zDeadband = 0.1;
    public final static double maxSpeed = 0.4;
    public final static double swerveCoefficient = 0.2;


    public final static double kP_DriveStraight = 0.001;
    public final static double kI_DriveStraight = 0.0;
    public final static double kD_DriveStraight = 0.0;

    public final static double kP_PointTurn = 0.001;
    public final static double kI_PointTurn = 0.0;
    public final static double kD_PointTurn = 0.0;

    public final static double kP_SwerveDrive = 0.001;
    public final static double kI_SwerveDrive = 0.0;
    public final static double kD_SwerveDrive = 0.0;

}
