package tdt4140.gr1801.app.core;


import junit.framework.TestCase;

public class TrainingTest extends TestCase{
	
	Training endurance;
	String date;
	
	public void setUp() {
		date = "20180227-xxxx";
		endurance = new Endurance(date, 90, 12, 555);
	}
	
	public void testGetDate() {
		assertEquals(date, endurance.getDate());
	}
	
	public void testGetDuration() {
		assertEquals(90, endurance.getDuration());
	}
	
	
	public void testNegativeDuration() {
		try {
			date = "20180227-xxxx";
			new Endurance(date, -100, 12, 555);
			fail();
		}
		catch
			(IllegalArgumentException iae) {
		}
	}

}
