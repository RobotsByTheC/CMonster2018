package org.usfirst.frc2084.CMonster2018.commands;

import org.usfirst.frc2084.CMonster2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoOutakeStop extends Command{
	
	
	public AutoOutakeStop() {
		setTimeout(2);
	}
	
	 @Override
	protected void initialize() {
		 
	}
	
	@Override
	protected void execute() {
		Robot.intakeBase.wheelsOutakeStart();
		
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
		 	Robot.intakeBase.wheelsOutakeStop();
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    @Override
	    protected void interrupted() {
	    }



	

}
