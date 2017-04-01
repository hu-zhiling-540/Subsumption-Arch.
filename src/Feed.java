import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class Feed implements Behavior{
	
	Long timeTrack;
	Boolean flag;
	LightSensor light;
	
	public Feed(LightSensor light)	{
		this.light = light;
		
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
