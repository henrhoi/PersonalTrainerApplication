package tdt4140.gr1801.app.core;


import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestNutrition extends TestCase {
	Nutrition nutrition;
	PersonalTrainer pt;
	Client client;
	String date1;
	List<Nutrition> testers;
	
	protected void setUp() {
		pt = new PersonalTrainer("Vilde123", "Halvor", "Nilsen", "Halvor@nilsen.com","90911287","20180227-xxxx");
		client = new Client(1,"Vilde",170,pt);
		date1 = "20180103-1400";
		nutrition = new Nutrition(date1, 1887, 63, 94, 236, client.getId());
		
		testers = new ArrayList<Nutrition>();
		for (int i = 1 ; i<= 13 ; i++) {
			String str = i < 10 ? "0"+i : i+"";
			String dato = "2018-" + str + "-01";
			testers.add(new Nutrition(dato, 1887, 63, 94, 236, client.getId()));
		}
	}
	
	public void testToString() {
		String year = "2018";
		String day = "01";
		for(Nutrition test : testers) {
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
	
	
	public void testGetDate() {
		assertEquals(nutrition.getDate(),date1);
	}
	
	public void testGetCalories() {
		assertEquals(nutrition.getCalories(),1887);
	}
	
	public void testGetFat() {
		assertEquals(nutrition.getFat(),63);
	}
	
	public void testGetCarbs() {
		assertEquals(nutrition.getCarbs(),94);
	}
	
	public void testGetProtein() {
		assertEquals(nutrition.getProtein(),236);
	}
	
	public void testGetClientId() {
		assertEquals(nutrition.getClientId(),1);
	}
	
	
	
	
	
}
