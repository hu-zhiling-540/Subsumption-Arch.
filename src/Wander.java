//import lejos.robotics.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*; 
//import lejos.nxt.*;

public class Wander implements Behavior{
	
//	public boolean isOn = true;
	private DifferentialPilot robot;
	
	
	/**
	 * Constructor
	 * @param robot
	 */
	public Wander(DifferentialPilot robot)	{
		this.robot = robot;
	}
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		int random = (int) (Math.random() * 3);
		
		try {
			if (random == 0)
				robot.forward();
			else if (random == 1)
				robot.backward();
			else	{
				int ranAngle = (1+(int) (Math.random() * 3))*90;
				robot.rotate(ranAngle);
			
			Thread.yield();
			Thread.sleep(1000); // Stops for a short time (one second)
			}
		}
		
		catch(InterruptedException ie) {}
		
	}

	@Override
	public void suppress() {
//		isOn = false;
		robot.stop();	
	}

}
