package org.usfirst.frc2084.CMonster2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ToLeftSwitchFromRight extends CommandGroup {
	
	
	
	public ToLeftSwitchFromRight() {
		
		//go to the left side of the switch from the middle
		
		
		addSequential(new Turn(45));
		addSequential(new AutoSwitchElevator());
        addSequential(new MoveForward(6.5));
        addSequential(new Turn(-45)); //possible
        addParallel(new AutoElevatorStall());
        addParallel(new AutoOutake());
        addParallel(new AutoOutakeStop());
		
		
//		addSequential(new MoveForward(2));
//		addSequential(new Turn(90));
//		addSequential(new MoveForward(3));
//		addSequential(new Turn(-90));
//		addSequential(new AutoSwitchElevator());
//		addParallel(new AutoElevatorStall());
//		addSequential(new MoveForward(1.75));
//		addParallel(new AutoOutake());
//        addParallel(new AutoOutakeStop());
	}

}
