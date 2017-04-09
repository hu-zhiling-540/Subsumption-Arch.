import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

//import lejos.robotics.*; 
//import lejos.robotics.navigation.*; 
//import lejos.robotics.subsumption.*; 


public class Robot {
	
	protected static final int TRAVEL_DIST = 20; 	
	protected static double WHEEL_CIRCUM = 16.957; //in cm diam = 6.35, 5.3975
	protected static double BASE_CIRCUM = 50; //diam = 17.145 (53.863)  - 16.51
	protected static double rotation_ratio = BASE_CIRCUM/WHEEL_CIRCUM;
	static int speedDrive = 300;
	
	protected static NXTRegulatedMotor leftMotor = Motor.C;
	protected static NXTRegulatedMotor rightMotor = Motor.A;
	
	
	// create a touch sensor object so that we can use a SensorListener to notify us when we  bump 
	protected static TouchSensor frontBump = new TouchSensor(SensorPort.S2);
//	protected static TouchSensor backBump = new TouchSensor(SensorPort.S2);	
	protected static LightSensor light = new LightSensor(SensorPort.S3);

	 
    public static void main(String [] args) { 
    	
        // for my current robot, touch sensor is on back, so want to travel backwards as default          
    	DifferentialPilot robot = new DifferentialPilot(5.6f, 11.0f, Motor.A, Motor.C, true);         
    	robot.setTravelSpeed(TRAVEL_DIST);
    	// the default behavior 
    	Behavior Wander = new Wander(robot);
 
        // the Bump class implements Behavior and deals with obstacle avoidance       
    	Behavior Avoid = new Avoid(robot, frontBump);
        
    	Behavior Feed = new Feed(light, true, robot);  
        
        // array of behaviors will be passed to arbitrator.  Order of behaviors in array specifies  priority. 
        // higher index => higher priority 
        Behavior [] bArr = {Wander, Avoid, Feed}; 
        
        //create the arbitrator 
        Arbitrator arby = new Arbitrator(bArr); 
 
        arby.start(); 
    } 
} 