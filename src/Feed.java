import java.util.Timer;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Feed implements Behavior{
	
	Timer timer;
	Boolean flag;
	LightSensor light; 
	Boolean floodlight;
	DifferentialPilot robot;
	
	/**
	 * Constructor create a light sensor object attached to the specified port, 
	 * and sets flood lighting on or off.
	 */
	public Feed(LightSensor light, boolean floodlight, DifferentialPilot robot)	{
		this.robot = robot;
		this.light = light;
		light = new LightSensor(SensorPort.S1);
		
		this.floodlight = floodlight; 
		floodlight = true; 	
		
		timer = new Timer(); 
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		// If the robot is over a food source 
		if(light.getLightValue()!= 0) { 
			// The robot should stop and feed for 3 seconds
			robot.stop(); 
			timer.schedule(null, 0);
			
		}
		
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
}
