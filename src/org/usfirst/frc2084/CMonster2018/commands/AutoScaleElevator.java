package org.usfirst.frc2084.CMonster2018.commands;

import org.usfirst.frc2084.CMonster2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoScaleElevator extends Command {
	
	
	public AutoScaleElevator() {
		setTimeout(2.75);
	}
	
	protected void initialize() {
		
	}
	
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
	
	 @Override
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
