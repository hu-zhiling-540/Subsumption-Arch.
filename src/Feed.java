import java.util.Timer;
import java.util.TimerTask;

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
	 * Constructor creates a light sensor object attached to the specified port, 
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


	/** 
	 * Method allows robot to stop and feed once it's over a food source. 
	 * If lightsensors has a brightness value between 0 and 100%, with
	 * 0 = darkness and 100 = intense sunlight (if sensors can detect and object),
	 * then it feed for 3 seconds and repeat every 5 seconds.
	 */
	@Override
	public void action() {
		
		if(light.getLightValue()!= 0) { 
			robot.stop(); 
			timer.scheduleAtFixedRate(new TimerTask() { 
				
				@Override
				public void run() { 
					flag = true; 
				}
			}, 3000,5000); 
		}
	}

	@Override
	public boolean takeControl() {
		return false;
	}

	@Override
	public void suppress() {
		robot.stop();	
		
	}
}
