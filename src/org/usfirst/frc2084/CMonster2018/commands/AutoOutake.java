package org.usfirst.frc2084.CMonster2018.commands;

import org.usfirst.frc2084.CMonster2018.Robot;
import org.usfirst.frc2084.CMonster2018.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class AutoOutake extends Command {
	
	public static SpeedController rightIntakeSpark = RobotMap.rightIntakeSpark;
	public static SpeedController leftIntakeSpark = RobotMap.leftIntakeSpark;

	public AutoOutake() {
		setTimeout(2);
	}
	
	 @Override
	protected void initialize() {
		 
	}
	
	@Override
	protected void execute() {
		Robot.intakeBase.wheelsOutakeStop();
		
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
		 	Robot.intakeBase.wheelsOutakeStart();
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    @Override
	    protected void interrupted() {
	    }


}
