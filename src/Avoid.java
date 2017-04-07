import lejos.robotics.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*; 
import lejos.nxt.*;

public class Avoid implements Behavior, SensorPortListener{
	
	public DifferentialPilot robot;

//	the bot will back  up and turn away from the obstacle. 
	public TouchSensor frontBump, backBump;
	public boolean frontPressed, backPressed;
	
	public static final int cellD = 30;

	/**
	 * Constructor:
	 * should take the  robot as a parameter, 
	 * as well as the TouchSensors.
	 * @param robot
	 * @param bump
	 */
	public Avoid(DifferentialPilot robot, TouchSensor frontBump, TouchSensor backBump)		{
		this.robot = robot;
		this.frontBump = frontBump;
		this.backBump = backBump;
		frontPressed = false;
		backPressed =false;
		
		// to the ports in which the bumpers are attached
		SensorPort.S1.addSensorPortListener(this);
		SensorPort.S4.addSensorPortListener(this);
//		this.frontBump = new TouchSensor(SensorPort.S1);
//		this.backBump = new TouchSensor(SensorPort.S2);		
		
	}

	
	@Override
	public boolean takeControl() {
		return frontPressed || backPressed;
	}

	
	@Override
	public void action() {
		try {
			// travel backwards by a cell
			robot.travel(-cellD,true); 
			
			int random = (int) Math.random() * 10;
			if(random % 2 == 0)
				robot.rotate(90);
			else
				robot.rotate(-90);
			
			Thread.yield();
			Thread.sleep(1000); // Stops for a short time (one second)
		}
		
		catch(InterruptedException ie) {}
		
	}

	@Override
	public void suppress() {
		robot.stop();	
	}
	
	
	/**
	 * iff either bump sensor is pressed, 
	 * @param aSource
	 * @param aOldValue
	 * @param aNewValue
	 */
	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
		if (frontBump.isPressed())
			frontPressed = true;
		if (backBump.isPressed())
			backPressed = true;
	}

}