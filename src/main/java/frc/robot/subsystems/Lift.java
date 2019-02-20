package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.LiftStop;
import frc.robot.commands.LiftTeleOp;


public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  CANSparkMax LiftieSpark = new CANSparkMax(RobotMap.LiftieSpark, MotorType.kBrushless);
  CANEncoder LiftieEncoder;
  CANPIDController LiftiePID;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, kMaxVelocity;
  public Lift() {

    LiftieEncoder = LiftieSpark.getEncoder();
    LiftiePID = LiftieSpark.getPIDController();

    // PID coefficients
    kP = 0.025; 
    kI = 3e-6;
    kD = 0; 
    kIz = 0; 
    kFF = 0.002; 
    kMaxOutput = .2; 
    kMinOutput = -.7;
    //kMaxVelocity = 3000;

    // set PID coefficients
    LiftiePID.setP(kP);
    LiftiePID.setI(kI);
    LiftiePID.setD(kD);
    LiftiePID.setIZone(kIz);
    LiftiePID.setFF(kFF);
    LiftiePID.setOutputRange(kMinOutput, kMaxOutput);
    //LiftieEncoder.setPositionConversionFactor(0.5625);

    LiftieSpark.setInverted(true);
    LiftieSpark.setIdleMode(IdleMode.kBrake);
    LiftieSpark.setClosedLoopRampRate(.5);
    
    //LiftieSpark.setRampRate(.5);
    
  }

  public void run(double position){

     
      //SmartDashboard.putNumber("Current Velocity", LiftieEncoder.getVelocity());
      SmartDashboard.putNumber("Setpoint", position);
      SmartDashboard.putNumber("Actual Position", LiftieEncoder.getPosition());
      LiftiePID.setReference(position, ControlType.kPosition);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new LiftTeleOp());
  }
}
