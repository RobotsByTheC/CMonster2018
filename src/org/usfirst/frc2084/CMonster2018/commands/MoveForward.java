// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2084.CMonster2018.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2084.CMonster2018.Robot;
import org.usfirst.frc2084.CMonster2018.RobotMap;
import org.usfirst.frc2084.CMonster2018.PID.DistancePID;
import org.usfirst.frc2084.CMonster2018.PID.HeadingPID;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class MoveForward extends Command {
	
	private final DistancePID distancePID = RobotMap.distancePID;
	private final HeadingPID headingPID = RobotMap.headingPID;
	private final WPI_TalonSRX leftTalon1 = RobotMap.driveBaseLeftTalon1;
	private final WPI_TalonSRX rightTalon1 = RobotMap.driveBaseRightTalon1;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_Distance;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    boolean executeCheck = false;
    boolean finishedCheck = false;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public MoveForward(double Distance) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_Distance = Distance;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	
    	System.out.println("Move Forward Initialize");
    	distancePID.enable();
    	headingPID.enable();
    	distancePID.ResetPID();
    	headingPID.ResetPID();
    	
    	
    	RobotMap.ahrs.reset();
    	Robot.driveBase.EnableDriveBase();
    	//encoder position is reset in "EnableDriveBase" so don't have to do it again
    	headingPID.setSetpoint(0);
    	
    	//setpoint of headingPID is zero
    	
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	distancePID.setSetpoint(m_Distance);
    	
    	//test with both "setPoint" and "set"
    	//set distancePID setpoint to distance parameter
    	Robot.driveBase.DriveAutonomous();
    	executeCheck = true;
    	SmartDashboard.putBoolean("MoveForwardRunning?", executeCheck); //this returns true so this execute method is running
    	SmartDashboard.putNumber("NAVX yaw", (double)RobotMap.ahrs.getYaw());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	System.out.println("DistancePIDOnTarget" + distancePID.onTarget());
    	 SmartDashboard.putBoolean("DistancePIDOnTarget?", distancePID.onTarget());
        return distancePID.onTarget();
       
        
      
    }
    
   

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	finishedCheck = true;
    	SmartDashboard.putBoolean("HasMoveForwardEnded?", finishedCheck);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	
    	
    }
}
