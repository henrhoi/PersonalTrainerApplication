package tdt4140.gr1801.app.core;

import java.util.Arrays;

import junit.framework.TestCase;

public class DayProgramTest extends TestCase{
	
	DayProgram dp;
	
	protected void setUp() {
		dp = new DayProgram("Monday", 90, 10.0, 5.5, "Intervaller", Arrays.asList());
		
	}
	
	public void testToString() {
		assertEquals(dp.toString(), "Monday");
	}
	
	public void testCompareDayProgramObjects() {
		DayProgram dp2 = new DayProgram("Tuesday", 90, 10.0, 5.5, "Intervaller", Arrays.asList());
		assertTrue(dp.compareTo(dp2) < 0);
	}
	

}
