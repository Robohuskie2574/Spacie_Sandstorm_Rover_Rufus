package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.GrabberStop;


public class Grabber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Spark GrabberSpark = new Spark(RobotMap.GrabberSpark);

  public void run(double speed){
    
    GrabberSpark.setSpeed(speed);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new GrabberStop());
  }
}
