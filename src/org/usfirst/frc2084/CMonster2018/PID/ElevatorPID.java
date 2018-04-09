package org.usfirst.frc2084.CMonster2018.PID;

import org.usfirst.frc2084.CMonster2018.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorPID extends PIDSubsystem{

	double Output;
	static double PIDOutput;
	static double PIDInput;
	
	public ElevatorPID() {
		super("ElevatorPID", 0.1, 0.0, 0.0);
		// TODO Auto-generated constructor stub
		
		setAbsoluteTolerance(0.2); //change after testing
		getPIDController().setContinuous(false);
		setInputRange(-10, 10);
		setOutputRange(-0.25, 0.25); //what percent of total speed the auto should run at
	}
	
	public void resetPID() {
		getPIDController().reset();
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.AverageDistance;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Output = (output);
		SmartDashboard.putNumber("ElevatorPIDOutput", Output);
		
	}
	
	public double getOutput() {
		return Output;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
