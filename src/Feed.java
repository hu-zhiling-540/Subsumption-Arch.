import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class Feed implements Behavior{
	
	Time timer;
	Boolean flag;
	LightSensor light; 
	Boolean floodlight;
	
	/**
	 * Constructor create a light sensor object attached to the specified port, 
	 * and sets floodlighting on or off.
	 */
	public Feed(LightSensor light, boolean floodlight)	{
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
		if(lightsensor.getVlaue != 0) { 
			// The robot should stop and feed for 3 seconds
			robot.stop(); 
			timer.schedule( )
			
			
			
		}
		
	}
}
