package tdt4140.gr1801.app.core;
import java.util.Date;

import junit.framework.TestCase;

public class EnduranceTest extends TestCase{
	
	Endurance endurance;
	
	@SuppressWarnings("deprecation")
	protected void setUp() {
		endurance = new Endurance(new Date(27, 02, 2018), 90, 12, 685);
	}
	
	public void testGetDistance() {
		assertEquals(12.0, endurance.getDistance());
	}
	
	public void testGetAverageSpeed() {
		assertEquals(8.0, endurance.getAverageSpeed());
	}
	
	public void testGetCaloriesBurned() {
		assertEquals(685, endurance.getCaloriesBurned());
	}
	

}
