package org.usfirst.frc2084.CMonster2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ToRightSwitchFromLeft extends CommandGroup{
	
	public ToRightSwitchFromLeft() {
		
		//go to the right side of the switch from the middle position
		
		
		
		addSequential(new Turn(-45));
		addSequential(new AutoSwitchElevator());
        addSequential(new MoveForward(6.5));
        addSequential(new Turn(45)); //possible
        addParallel(new AutoElevatorStall());
        addParallel(new AutoOutake());
        addParallel(new AutoOutakeStop());
		
		
		
//		addSequential(new MoveForward(1.5));
//		addSequential(new Turn(-90));
//		addSequential(new MoveForward(2.2));
//		addSequential(new Turn(90));
//		addSequential(new AutoSwitchElevator());
//		addParallel(new AutoElevatorStall());
//		addSequential(new MoveForward(1.4));
//		addParallel(new AutoOutake());
//        addParallel(new AutoOutakeStop());
	}

}
