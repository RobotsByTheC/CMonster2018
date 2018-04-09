package org.usfirst.frc2084.CMonster2018.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class ForwardOnly extends CommandGroup {
	
	public ForwardOnly() {
		addSequential(new MoveForward(5));
	}
	
	
}
