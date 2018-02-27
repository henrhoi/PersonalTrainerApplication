package tdt4140.gr1801.app.core;

import java.util.Date;

import junit.framework.TestCase;

public class TrainingTest extends TestCase{
	
	Training endurance;
	Date date;
	
	public void setUp() {
		date = new Date(28, 02, 2018);
		endurance = new Endurance(date, 90, 12, 555);
	}
	
	public void testGetDate() {
		assertEquals(date, endurance.getDate());
	}
	
	public void testGetDuration() {
		assertEquals(90, endurance.getDuration());
	}
	

}
