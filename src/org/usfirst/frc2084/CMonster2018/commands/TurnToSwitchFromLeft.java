package org.usfirst.frc2084.CMonster2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnToSwitchFromLeft extends CommandGroup{
	
	public TurnToSwitchFromLeft()  {
		addSequential(new MoveForward(7.5));
		addSequential(new Turn(-80));
		
		addSequential(new AutoSwitchElevator());
		//addSequential(new AutoElevatorStall());
		addSequential(new MoveForward(0.1));
        addParallel(new AutoOutake());
        addParallel(new AutoOutakeStop());
	}

}
