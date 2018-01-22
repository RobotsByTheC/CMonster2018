package org.usfirst.frc2084.CMonster2018.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc2084.CMonster2018.subsystems.DriveBase;

public class DistancePID extends PIDSubsystem {
	
	double Output;
	static double PIDOutput;
	static double PIDInput;
	
	public DistancePID() {
		
		super("DistancePID", 0.0, 0.0, 0.0);
		//NEED TO BE TUNED
		
		setAbsoluteTolerance(0.2); //change after testing
		getPIDController().setContinuous(false);
		setInputRange(-10, 10);
		setOutputRange(-0.25, 0.25); //what percent of total speed the auto should run at
		
		
	}
	
	public void ResetPID() {
		getPIDController().reset();
	}
	
	
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Output = (output);
				
	}
	
	public double getOutput(){
		return Output;
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

}
