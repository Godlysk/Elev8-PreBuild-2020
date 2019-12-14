/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public Joystick joy1, joy2;
  public Encoder enc_R, enc_L;
  public AHRS navx;

  public OI() {
    joy1 = new Joystick(1);
    //joy2 = new Joystick(2);

    enc_L = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
    enc_R = new Encoder(8, 9, false, Encoder.EncodingType.k4X);
    navx = new AHRS(SPI.Port.kMXP);
  }
 

  public double getY(final Joystick joy, final double band) {
    // Inverted (Joystick moved forwards gives negtive reading)
    double val = -joy.getY();

    if (Math.abs(val) < band)
        val = 0;
    else {
        val = val - Math.signum(val) * band;
    }

    return val;
  }

  public double getZ(final Joystick joy, final double band) {
    double val = joy.getZ();

    if (Math.abs(val) < band)
        val = 0;
    else {
        val = val - Math.signum(val) * band;
    }

    return val;
  }

  public double getX(final Joystick joy, final double band) {

    double val = joy.getX();

    if (Math.abs(val) < band)
        val = 0;
    else {
        val = val - Math.signum(val) * band;
    }

    return val;
  }

  /*
  * Axis == 0 is X
  * Axis == 1 is Y
  * Axis == 2 is Z
  */

  public double getAxisMeasure(Joystick joy, double band, int axis) {

    double val = 0;
    if (axis == 0) val = joy.getX();
    else if (axis == 1) val = -joy.getY();
    else if (axis == 2) val = joy.getZ();

    if (Math.abs(val) < band) val = 0;
    else {
      val = val - Math.signum(val)*band;
    }

    return val;
  }
  

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
