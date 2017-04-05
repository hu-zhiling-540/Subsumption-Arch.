import lejos.robotics.*;
import lejos.robotics.navigation.DifferentialPilot;
//import lejos.robotics.navigation.ArcMoveController;
import lejos.robotics.subsumption.*; 
import lejos.nxt.*;

public class Wander implements Behavior{
	
	public boolean isOn = true;
	private DifferentialPilot robot;
//	http://www.lejos.org/nxt/nxj/api/lejos/robotics/navigation/DifferentialPilot.html
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
		if (random == 0)
			robot.forward();
		else if (random == 1)
			robot.backward();
		else	{
			int ranAngle = (1+(int) (Math.random() * 3))*90;
			robot.rotate(ranAngle);
		}
	}

	@Override
	public void suppress() {
		isOn = false;
	}

}
