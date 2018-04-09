package org.usfirst.frc2084.CMonster2018.Drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class JoystickSensitivity {

	
	double Sensitivity = 1.0;
	double Output;
	boolean check = false;
	
	public double GetOutput(double Input) {
		
		check = true;
		SmartDashboard.putBoolean("DidJoystickSensitivityGetCalled?", check);
		
		
		Output = Sensitivity * Math.pow(Input, 3) + (1-Sensitivity) * Input;
			
		return Output;
		
		
	}
	
	
}
