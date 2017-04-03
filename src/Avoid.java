import lejos.robotics.*;
import lejos.robotics.navigation.ArcMoveController;
import lejos.robotics.subsumption.*; 
import lejos.nxt.*;

public class Avoid implements Behavior{
	
	public ArcMoveController robot;
	public TouchSensor bump;

	/**
	 * Constructor
	 * @param robot
	 * @param bump
	 */
	public Avoid(ArcMoveController robot, TouchSensor bump)		{
		this.robot = robot;
		this.bump = bump;
		
		
	}
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}