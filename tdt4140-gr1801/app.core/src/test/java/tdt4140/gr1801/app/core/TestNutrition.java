package tdt4140.gr1801.app.core;


import junit.framework.TestCase;

public class TestNutrition extends TestCase {
	Nutrition nutrition;
	PersonalTrainer pt;
	Client client;
	String date1;
	
	protected void setUp() {
		pt = new PersonalTrainer("Vilde123", "Halvor", "Nilsen", "Halvor@nilsen.com","90911287","1234567890", date1);
		client = new Client(1,"Vilde",170,pt);
		date1 = "20180103-1400";
		nutrition = new Nutrition(date1, 1887, 63, 94, 236, client.getId());
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
