package org.usfirst.frc2084.CMonster2018.commands;

import org.usfirst.frc2084.CMonster2018.Robot;
import org.usfirst.frc2084.CMonster2018.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class AutoSwitchElevator extends Command{
	
	public static WPI_TalonSRX elevatorTalon = RobotMap.elevatorTalon;
	
	public AutoSwitchElevator() {
		setTimeout(1.5);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Robot.elevatorBase.autoElevatorUpStart();
	
		
	}
	
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	@Override
	public void cancel() {
		//Robot.elevatorBase.elevatorDownStop();
	}
	
	 protected void end() {
		Robot.elevatorBase.elevatorDownStop();
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    @Override
	    protected void interrupted() {
	    	end();
	    }
	    

}
