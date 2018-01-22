package org.usfirst.frc2084.CMonster2018.Drive;

import org.usfirst.frc2084.CMonster2018.RobotMap;

import com.kauailabs.navx.frc.AHRS;

public class AutonomousDrive {
	
	boolean inPosition;
	double leftDistance;
	double rightDistance;
	double AverageDistance;
	
	double [] WayPoints = new double[3] ;  // array with 3 elements holding the distance to each way point;
    double [] WayPointAngle = new double[3] ;  //angle to the next way point
    double[] ReturnData = new double[2];  // place holder for distance and angle 
    public static int Waypoint = 0;   // way point index stating at 0.
    private final AHRS ahrs = RobotMap.ahrs; 
    

    public double[] getWayPoint() {
    	
    	WayPoints[0] = 2.2;  //Relative distance to each way point in meters.
	    WayPoints[1] = 0.0;	
	    WayPoints[2] = 1.5;	
	  	
	    WayPointAngle[0] = 0.0;  //Relative angle to each way point in degrees.
	    WayPointAngle[1] = 20;	
	    WayPointAngle[2] = 0.0;	
	    
	    
     	AverageDistance = (leftDistance + rightDistance) / 2;  // Calculate the average distance traveled.
     	//this average distance is different than RobotMap.AverageDistance
     	
     	double Yaw = ahrs.getYaw();
     	
     	
     	
    	
    	switch(Waypoint){
    	
	    	case 0:{
	    		
	    		if (AverageDistance >= WayPoints[0]) {   //When in position go to next way point
	    			Waypoint = 1;  //index way point
	    		}
	    			
	    		ReturnData[0] = WayPoints[0];
	    		ReturnData[1] = WayPointAngle[0];
	    		
	    	}
	    	
	    	case 1:{
	    		
	    		if (Yaw == WayPointAngle[1] ){
	    			Waypoint = 2;  //index way point	
	    		}
	    		
	    		ReturnData[0] = WayPoints[1];
	    		ReturnData[1] = WayPointAngle[1];
	    		
	    		
	    	}
	    	
	    	case 2:{
	    		
	    		if (AverageDistance >= WayPoints[2]) {   //When in position go to next way point
	    			Waypoint = 3;  //index way point ***There is no 3 yet
	    		}
	    		ReturnData[0] = WayPoints[2];
	    		ReturnData[1] = WayPointAngle[2];
	    		
	    		
	    	}
	}
    	
     	
		return ReturnData;
 		

}
}
