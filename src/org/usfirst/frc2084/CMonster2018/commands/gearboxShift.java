package org.usfirst.frc2084.CMonster2018.commands;

import org.usfirst.frc2084.CMonster2018.Robot;
import org.usfirst.frc2084.CMonster2018.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class gearboxShift extends Command{
	
	private static DoubleSolenoid shiftingGearboxSolenoid = RobotMap.shiftingGearboxSolenoid;
	
	public gearboxShift() {
		
	}
	
	 protected void initialize() {
	    	//move the pneumatic to shift gears in the gearbox
		 
		// Robot.driveBase.shifted = !Robot.driveBase.shifted;
		 
//		 	if (Robot.driveBase.shifted == true) {
//		 		Robot.driveBase.shiftGearboxBackward();
//		 	}
//		 	else {
//		 		Robot.driveBase.shiftGearboxForward();
//		 	}
		 
		 
		 Robot.driveBase.shiftGearboxForward();
		 
	    }

	 
	    // Called repeatedly when this Command is scheduled to run
	    @Override
	    protected void execute() {
	    }
	    

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	 // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
	
}
