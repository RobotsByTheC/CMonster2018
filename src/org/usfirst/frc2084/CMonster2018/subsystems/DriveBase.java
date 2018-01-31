// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2084.CMonster2018.subsystems;

import org.usfirst.frc2084.CMonster2018.Robot;
import org.usfirst.frc2084.CMonster2018.RobotMap;
import org.usfirst.frc2084.CMonster2018.Drive.ArcadeDrive;
import org.usfirst.frc2084.CMonster2018.PID.DistancePID;
import org.usfirst.frc2084.CMonster2018.PID.HeadingPID;
import org.usfirst.frc2084.CMonster2018.commands.*;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveBase extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS


	
	private final WPI_TalonSRX rightTalon1 = RobotMap.driveBaseRightTalon1;
	private final WPI_TalonSRX leftTalon1 = RobotMap.driveBaseLeftTalon1;
	private final WPI_VictorSPX rightVictor1 = RobotMap.driveBaseRightVictor1;
	private final WPI_VictorSPX leftVictor1 = RobotMap.driveBaseLeftVictor1;
	// the drive motor controllers 
	
	
	private final DoubleSolenoid shiftingGearboxSolenoid = RobotMap.shiftingGearboxSolenoid;
	
	private final AHRS ahrs = RobotMap.ahrs; //navX gyro
	
	public static double leftMotorSpeed;
	public static double rightMotorSpeed;
	double moveSpeed;
	double rotateSpeed;
	public static double LeftDistance;
	public static double RightDistance;
	ArcadeDrive arcadeDrive = new ArcadeDrive();
	private final double WheelDiameter = RobotMap.DRIVE_SUBSYSTEM_WHEEL_DIAMETER;
	Joystick RightJoystick;
	Joystick LeftJoystick;
	double[] returnData = new double[2];
	public static boolean shifted = false;
	
	HeadingPID headingPID = RobotMap.headingPID;
	DistancePID distancePID = RobotMap.distancePID;
	
	public void EnableDriveBase() {
		//don't have to reset anymore because setting to zero does that already
		//don't have to enable anymore because the default of the talons is enabled
	
		rightTalon1.set(0);
		leftTalon1.set(0);
		Robot.intakeBase.CompressorOn();
	}
	
	public void DisableDriveBase() {
		rightTalon1.disable();
		leftTalon1.disable();
		rightVictor1.disable();
		leftVictor1.disable();
		
	}
	
	public void shiftGearboxForward() {
		shiftingGearboxSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void shiftGearboxBackward() {
		shiftingGearboxSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void DriveAutonomous() {
		//autonomous method
		moveSpeed = distancePID.getOutput();
		rotateSpeed = headingPID.getOutput();
		returnData = arcadeDrive.calculateSpeed(moveSpeed, rotateSpeed);
		leftMotorSpeed = returnData[0];
		rightMotorSpeed = returnData[1];
		
		
		leftTalon1.set(leftMotorSpeed * 586); //not sure if max rpm is 586
		//this might change with the shifting gearboxes
		rightTalon1.set(rightMotorSpeed * 586);
		
		LeftDistance = leftTalon1.getSelectedSensorPosition(0) * RobotMap.DISTANCE_PER_ROTATION;
		RightDistance = rightTalon1.getSelectedSensorPosition(0) * RobotMap.DISTANCE_PER_ROTATION;
		
		
		
		LeftDistance *= -1;
		RobotMap.AverageDistance = (LeftDistance + RightDistance) / 2;
		
	}
	
	public void JoystickInputs(Joystick RightJoystick, Joystick LeftJoystick) {
		//teleoperated method 
		leftMotorSpeed = LeftJoystick.getY(); //get value from 1 to -1 from the joysticks, then set it to the talons
		rightMotorSpeed = RightJoystick.getY();
		rightTalon1.set(rightMotorSpeed * -1); //once running closed loop, need to multiply by max rpm+
		leftTalon1.set(leftMotorSpeed * -1); 
		rightVictor1.set(rightMotorSpeed * -1); //bypass the follower mode for now since it doesn't work
		leftVictor1.set(leftMotorSpeed * -1); 
		
		
		
		if (shifted == true) {
			shiftingGearboxSolenoid.set(DoubleSolenoid.Value.kForward);
		}
		else {
			shiftingGearboxSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
		
	
		SmartDashboard.putNumber("LeftSpeed", leftMotorSpeed); //show data on the smart dashboard
		SmartDashboard.putNumber("RightSpeed", rightMotorSpeed);
	}
	
	
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    	 setDefaultCommand(new DriveWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

