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

    public Button commandBrakeButton, commandSteerButton;
    public int steerButtonNumber = 2;
    public int brakeButtonNumber = 7;
    

    public Joystick1() {
        commandBrakeButton = new JoystickButton(Robot.oi.joy1, brakeButtonNumber);

        commandSteerButton = new JoystickButton(Robot.oi.joy1, steerButtonNumber);
        commandSteerButton.whenPressed(new CommandSteer());
    }

    


}
