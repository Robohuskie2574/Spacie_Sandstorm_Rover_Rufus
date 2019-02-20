package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TeleOp;
  
public class Drive extends Subsystem {

  //Define variables here 
  // <Class> <name of variable> = new <Class constructor>
  WPI_TalonSRX FrontLeftTalon = new WPI_TalonSRX(RobotMap.frontLeftMotor);
  WPI_TalonSRX FrontRightTalon = new WPI_TalonSRX(RobotMap.frontRightMotor);
  WPI_TalonSRX RearLeftTalon = new WPI_TalonSRX(RobotMap.backLeftMotor);
  WPI_TalonSRX RearRightTalon = new WPI_TalonSRX(RobotMap.backRightMotor);

  MecanumDrive drive;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Drive(){
    FrontRightTalon.setInverted(false);
    RearLeftTalon.setInverted(true);
    FrontLeftTalon.setInverted(false);
    RearRightTalon.setInverted(false);
    drive = new MecanumDrive(FrontLeftTalon, RearLeftTalon, FrontRightTalon, RearRightTalon);

    drive.setRightSideInverted(false);
  }
  
  public void drive(double twist, double yAxis, double xAxis) {

    if(twist > 0.08 || twist < -0.08 || xAxis > 0.08 || xAxis < -0.08 || yAxis > 0.08 || yAxis < -0.08) {
      drive.driveCartesian(xAxis * .8, -yAxis * .8, twist * .7);
    } else{
      drive.driveCartesian(0,0,0);
    }
    SmartDashboard.putNumberArray("motoroutputs", new Double[]{FrontLeftTalon.get(), FrontRightTalon.get(), RearLeftTalon.get(), RearRightTalon.get()});
    
  }

  @Override
  public void initDefaultCommand(){
    setDefaultCommand(new TeleOp());
  }
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  
}