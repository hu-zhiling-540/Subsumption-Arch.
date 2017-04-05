import lejos.robotics.*;
import lejos.robotics.navigation.DifferentialPilot;
//import lejos.robotics.navigation.ArcMoveController;
import lejos.robotics.subsumption.*; 
import lejos.nxt.*;

public class Wander implements Behavior{
	
	public boolean isOn = true;
	private DifferentialPilot robot;
//	private ArcMoveController robot;
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
		int angle = 0; // random
		Motor.A.rotate(angle);
		Motor.C.rotate(angle);
		while (isOn)	{
			Thread.yield();
			Motor.A.stop();
			Motor.C.stop();
		}
//		robot.forward(); 
//		double randomAngle;	// neg to the right, pos to the left; from -180 to 180
//		robot.travelArc(randomAngle, distance, immediateReturn);
	}

	@Override
	public void suppress() {
		isOn = false;
	}

}
