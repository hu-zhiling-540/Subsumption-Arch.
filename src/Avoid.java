import lejos.robotics.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*; 
import lejos.nxt.*;

public class Avoid implements Behavior, SensorPortListener{
	
	public DifferentialPilot robot;
//	if either bump sensor is pressed, 
//	the bot will back  up and turn away from the obstacle. 
//	public TouchSensor leftBump;
//	public TouchSensor rtBump;
	public TouchSensor bump;
	public static final int cellD = 30;

	/**
	 * Constructor:
	 * should take the  robot as a parameter, 
	 * as well as the TouchSensors.
	 * @param robot
	 * @param bump
	 */
	public Avoid(DifferentialPilot robot, TouchSensor bump)		{
		this.robot = robot;
		this.bump = bump;
		// to the ports in which the bumpers are attached
		SensorPort.S1.addSensorPortListener(this);
		SensorPort.S2.addSensorPortListener(this);
//		this.leftBump = new TouchSensor(SensorPort.S1);
//		this.rtBump = new TouchSensor(SensorPort.S2);		
		
	}
	@Override
	public boolean takeControl() {
		return bump.isPressed();
	}

	@Override
	public void action() {
		// check the sensors
		try {
			robot.travel(-cellD,true); 
			robot.rotate(90);
//			robot.rotate(-90);
			
			Thread.yield();
			Thread.sleep(1000); // Stops for a short time (one second)
		}
		catch(InterruptedException ie) {}
		// Stops one motor and thus turns the robot
		
//		Motor.A.stop();
//		try {
//			Thread.yield();
//			Thread.sleep(300); // // Stops for a short time (3/10ths second)
//		}
//		catch(InterruptedException ie) {}
//		Motor.C.stop();
		
		
	}

	@Override
	public void suppress() {
		robot.stop();	
	}
	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
			
			
		
	}

}