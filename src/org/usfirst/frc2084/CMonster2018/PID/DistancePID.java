package org.usfirst.frc2084.CMonster2018.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
=======
>>>>>>> af3868b1acf66bfe1e604fdf4b1ccee0fc457a0e

import org.usfirst.frc2084.CMonster2018.RobotMap;
import org.usfirst.frc2084.CMonster2018.subsystems.DriveBase;

public class DistancePID extends PIDSubsystem {
	
	double Output;
	static double PIDOutput;
	static double PIDInput;
	boolean constructorCheck = false;
	
	public DistancePID() {
		
		super("DistancePID", 0.1, 0.0, 0.0);
		//NEED TO BE TUNED
		
		setAbsoluteTolerance(0.2); //change after testing
		getPIDController().setContinuous(false);
		setInputRange(-10, 10);
		setOutputRange(-0.1, 0.1); //what percent of total speed the auto should run at
		
		constructorCheck = true;
		SmartDashboard.putBoolean("DidDistancePIDRun?", constructorCheck);
	}
	
	public void ResetPID() {
		getPIDController().reset();
	}
	
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.AverageDistance;
	}
	
<<<<<<< HEAD
	protected void usePIDOutput(double output) { 
=======
	
	
	protected void usePIDOutput(double output) {
>>>>>>> af3868b1acf66bfe1e604fdf4b1ccee0fc457a0e
		// TODO Auto-generated method stub
		Output = (output);
		SmartDashboard.putNumber("DistancePIDOutput", Output);
				
	}
	
	public double getOutput(){
		return Output;
		
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

<<<<<<< HEAD
	
	
=======
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.AverageDistance;
	}
>>>>>>> af3868b1acf66bfe1e604fdf4b1ccee0fc457a0e

}
