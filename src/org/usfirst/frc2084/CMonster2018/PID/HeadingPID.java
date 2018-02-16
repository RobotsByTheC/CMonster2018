package org.usfirst.frc2084.CMonster2018.PID;

import org.usfirst.frc2084.CMonster2018.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class HeadingPID extends PIDSubsystem{
	
	double Output;
	double yawOutput;
	
	public HeadingPID () {
		
		super("HeadingPID", 0.06, 0.0, 0.0);  //calls the parent constructor with arguments P,I,D
		//NEED TO BE TUNED
		
		setAbsoluteTolerance(0.5);          // more parameters
		getPIDController().setContinuous(false);
		setInputRange(-180.0,  180.0);
	    setOutputRange(-0.25, 0.25);
	    
	    
	}
	
	public void ResetPID(){  //reset the PID controller
		getPIDController().reset();
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		yawOutput = (double) RobotMap.ahrs.getYaw();
		//yawOutput *= -1;
		return yawOutput;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Output = (output);
		
	}

	
	
	public double getOutput(){  // called from the DriveBasePID 
		return Output;
   }    	
 

}
