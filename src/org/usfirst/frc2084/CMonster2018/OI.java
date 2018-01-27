 // RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2084.CMonster2018;

import org.usfirst.frc2084.CMonster2018.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

   
    	
    	 // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
        public Joystick rightJoystick;
        public Joystick leftJoystick;
        public JoystickButton climberUpStart;
        public JoystickButton climberUpStop;
        public JoystickButton climberDownStart;
        public JoystickButton climberDownStop;
        public JoystickButton wheelsOutStart;
        public JoystickButton wheelsOutStop;
        public JoystickButton wheelsInStart;
        public JoystickButton wheelsInStop;
        public JoystickButton elevatorAscendStart;
        public JoystickButton elevatorAscendStop;
        public JoystickButton elevatorDescendStart;
        public JoystickButton elevatorDescendStop;
        public JoystickButton intakeUp;
        public JoystickButton intakeDown;
        public JoystickButton switchGearbox; //new button to manually switch shifting gearbox
        public Joystick logitech;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

        public OI() {
            // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

            logitech = new Joystick(2);
            leftJoystick = new Joystick(1);        
            rightJoystick = new Joystick(0);
            
            intakeDown = new JoystickButton(logitech, 4);
            intakeDown.whenPressed(new intakeFoldDown());
            intakeUp = new JoystickButton(logitech, 2);
            intakeUp.whenPressed(new intakeFoldUp());
            elevatorDescendStop = new JoystickButton(logitech, 8);
            elevatorDescendStop.whenReleased(new elevatorDownStop());
            elevatorDescendStart = new JoystickButton(logitech, 8);
            elevatorDescendStart.whileHeld(new elevatorDownStart());
            elevatorAscendStop = new JoystickButton(logitech, 6);
            elevatorAscendStop.whenReleased(new elevatorUpStop());
            elevatorAscendStart = new JoystickButton(logitech, 6);
            elevatorAscendStart.whileHeld(new elevatorUpStart());
            wheelsInStop = new JoystickButton(logitech, 5);
            wheelsInStop.whenReleased(new wheelsIntakeStop());
            wheelsInStart = new JoystickButton(logitech, 5);
            wheelsInStart.whileHeld(new wheelsIntakeStart());
            wheelsOutStop = new JoystickButton(logitech, 7);
            wheelsOutStop.whenReleased(new wheelsOutakeStop());
            wheelsOutStart = new JoystickButton(logitech, 7);
            wheelsOutStart.whileHeld(new wheelsOutakeStart());
            climberDownStop = new JoystickButton(logitech, 9);
            climberDownStop.whenReleased(new climbDownStop());
            climberDownStart = new JoystickButton(logitech, 9);
            climberDownStart.whileHeld(new climbDownStart());
            climberUpStop = new JoystickButton(logitech, 1);
            climberUpStop.whenReleased(new climbUpStop());
            climberUpStart = new JoystickButton(logitech, 1);
            climberUpStart.whileHeld(new climbUpStart());
            
            switchGearbox = new JoystickButton(rightJoystick, 1);
            switchGearbox.whenPressed(new gearboxShift());
            //need to have the gearboxShift command "extends Command" 
            //also, make sure to choose the "button" version of "whenPressed", not the trigger version
            //make sure there are is an initialize and execute method in the command for oi to recognize it
           
            


            // SmartDashboard Buttons
            SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
            SmartDashboard.putData("MiddleToRightSwitch", new MiddleToRightSwitch());
            SmartDashboard.putData("MiddleToLeftSwitch", new MiddleToLeftSwitch());
            SmartDashboard.putData("RightToRightSwitch", new RightToRightSwitch());
            SmartDashboard.putData("LeftToLeftSwitch", new LeftToLeftSwitch());
            SmartDashboard.putData("LeftToLeftScale", new LeftToLeftScale());
            SmartDashboard.putData("RightToRightScale", new RightToRightScale());
            SmartDashboard.putData("RightNotToScale", new RightNotToScale());
            SmartDashboard.putData("LeftNotToScale", new LeftNotToScale());
            SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
            SmartDashboard.putData("wheelsOutakeStart", new wheelsOutakeStart());
            SmartDashboard.putData("wheelsOutakeStop", new wheelsOutakeStop());
            SmartDashboard.putData("wheelsIntakeStart", new wheelsIntakeStart());
            SmartDashboard.putData("wheelsIntakeStop", new wheelsIntakeStop());
            SmartDashboard.putData("climbUpStart", new climbUpStart());
            SmartDashboard.putData("climbUpStop", new climbUpStop());
            SmartDashboard.putData("climbDownStart", new climbDownStart());
            SmartDashboard.putData("climbDownStop", new climbDownStop());
            SmartDashboard.putData("elevatorUpStart", new elevatorUpStart());
            SmartDashboard.putData("elevatorUpStop", new elevatorUpStop());
            SmartDashboard.putData("elevatorDownStart", new elevatorDownStart());
            SmartDashboard.putData("elevatorDownStop", new elevatorDownStop());
            SmartDashboard.putData("intakeFoldUp", new intakeFoldUp());
            SmartDashboard.putData("intakeFoldDown", new intakeFoldDown());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        }

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
        public Joystick getRightJoystick() {
            return rightJoystick;
        }

        public Joystick getLeftJoystick() {
            return leftJoystick;
        }

        public Joystick getLogitech() {
            return logitech;
        }


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    	
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS




    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  


