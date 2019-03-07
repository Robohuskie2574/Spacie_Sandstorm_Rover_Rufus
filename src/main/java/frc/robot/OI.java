package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.GrabberIn;
import frc.robot.commands.GrabberOut;
import frc.robot.commands.LiftLoadCargo;
//import frc.robot.commands.LiftDown;
import frc.robot.commands.LiftTeleOp;
//import frc.robot.commands.LiftUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);driveCartesian(yAxis, xAxis, twist);
  // Button button = new JoystickButton(stick, buttonNumber);

  Joystick stick = new Joystick(0);
  Joystick liftstick = new Joystick(1);

  public double getTwist() {
    return stick.getTwist();
  }
  public double getXAxis() {
    return stick.getX();
  }
  public double getYAxis() {
    return stick.getY();
  }
  public double getSlider() {
    return -liftstick.getRawAxis(3);
  }


  Button GrabberInButton = new JoystickButton(stick, 1);
  Button GrabberOutButton = new JoystickButton(stick, 2);

  //Button liftUpButton = new JoystickButton(stick, 5);
  Button liftLoadCargoButton = new JoystickButton(liftstick, 11);
  Button liftSafetyButton = new JoystickButton (liftstick, 12);

  public OI() {
    GrabberInButton.whileHeld(new GrabberIn());
    GrabberOutButton.whileHeld(new GrabberOut());
    //liftUpButton.whileHeld(new LiftUp());
    liftLoadCargoButton.whenPressed(new LiftLoadCargo());
    liftSafetyButton.whenPressed(new LiftTeleOp());
  }



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

