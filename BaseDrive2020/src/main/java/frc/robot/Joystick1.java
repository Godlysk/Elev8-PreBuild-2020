/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.Robot;
import frc.robot.Drive.*;

public class Joystick1 {

    Button commandBrakeButton, armMoveUpButton, armMoveDownButton;

    public int brakeButton = 1; public int MoveUpButton = 2; public int MoveDownButton = 3;

    public Joystick1() {
        commandBrakeButton = new JoystickButton(Robot.oi.joy1, brakeButton);
        commandBrakeButton.whileHeld(new CommandBrake());
        armMoveUpButton = new JoystickButton(Robot.oi.joy1, MoveUpButton);
        armMoveDownButton = new JoystickButton(Robot.oi.joy1, MoveDownButton);
    }

    


}
