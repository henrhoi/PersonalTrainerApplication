package tdt4140.gr1801.app.core;


import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TrainingTest extends TestCase{
	
	Training endurance;
	String date;
	
	List<Endurance> testers;
	
	public void setUp() {
		date = "20180227-xxxx";
		endurance = new Endurance(date, 90, 12, 555,200,120);
		
		testers = new ArrayList<Endurance>();
		for (int i = 1 ; i<= 13 ; i++) {
			String str = i < 10 ? "0"+i : i+"";
			String dato = "2018-" + str + "-01";
			testers.add(new Endurance(dato, 90, 12, 555,200,120));
		}
	}
	
	public void testToString() {
		String year = "2018";
		String day = "01";
		for(Endurance test : testers) {
			String str;
			switch(test.getDate().substring(5,7)) {
			case "01": str = day + ". Jan " + year;break;
			case "02": str = day + ". Feb " + year;break;
			case "03": str = day + ". Mar " + year;break;
			case "04": str = day + ". Apr " + year;break;
			case "05": str = day + ". May " + year;break;
			case "06": str = day + ". Jun " + year;break;
			case "07": str = day + ". Jul " + year;break;
			case "08": str = day + ". Aug " + year;break;
			case "09": str = day + ". Sep " + year;break;
			case "10": str = day + ". Oct " + year;break;
			case "11": str = day + ". Nov " + year;break;
			case "12": str = day + ". Des " + year;break;
			default: str = "";break;
			}
			assertEquals(str, test.toString());
		}
	}
	
	public void testNullToString(){
		Endurance nullerud = null;
		assertEquals(null, nullerud);
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
			new Endurance(date, -100, 12, 555, 195, 180);
			fail();
		}
		catch
			(IllegalArgumentException iae) {
		}
	}

}
