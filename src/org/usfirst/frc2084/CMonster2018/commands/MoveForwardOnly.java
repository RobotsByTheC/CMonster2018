package org.usfirst.frc2084.CMonster2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardOnly extends CommandGroup{
	
	public MoveForwardOnly() {
		addSequential(new MoveForward(6));
	}

}
