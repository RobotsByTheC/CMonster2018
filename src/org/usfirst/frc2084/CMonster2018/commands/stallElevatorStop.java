package org.usfirst.frc2084.CMonster2018.commands;

import org.usfirst.frc2084.CMonster2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class stallElevatorStop extends Command{

	public stallElevatorStop() {
		
	}
	
	
	protected void initialize() {
		Robot.elevatorBase.stallElevatorStop();
	}
	
	protected void execute() {
		
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

}
