package tdt4140.gr1801.app.core;


import junit.framework.TestCase;



public class EnduranceTest extends TestCase{
	
	Endurance endurance;
	
	protected void setUp() {
		endurance = new Endurance("20180227-xxxx", 90, 12, 685, 200, 188);
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
	
	public void testNegativeDistance() {
		try {
			new Endurance("20180227-xxxx", 10, -12, 685, 195, 178);
			fail(); // Not supposed to get here
		}
		catch (IllegalArgumentException iae) {
			// Supposed to get here
		}
		catch (Exception e) {
			fail(); // Not supposed to get here
		}
	}
	
	public void testNegativeCaloriesBurned() {
		try {
			new Endurance("20180227-xxxx", 10, 12, -500, 190, 180);

			fail(); // Not supposed to get here
		}
		catch (IllegalArgumentException iae) {
			// Supposed to get here
		}
		catch (Exception e) {
			fail(); // Not supposed to get here
		}
	}
	
}
