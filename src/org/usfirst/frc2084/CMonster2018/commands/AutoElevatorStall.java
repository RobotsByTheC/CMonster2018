package org.usfirst.frc2084.CMonster2018.commands;

import org.usfirst.frc2084.CMonster2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoElevatorStall extends Command{

	public AutoElevatorStall() {
		setTimeout(4);
	}
	
	 @Override
	protected void initialize() {
		 
	}
	
	@Override
	protected void execute() {
		Robot.elevatorBase.stallElevatorStart();
		
	} 
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	@Override
	public void cancel() {
		
	}
	
	
	 protected void end() {
		 	Robot.elevatorBase.elevatorUpStop();
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    @Override
	    protected void interrupted() {
	    }


}
