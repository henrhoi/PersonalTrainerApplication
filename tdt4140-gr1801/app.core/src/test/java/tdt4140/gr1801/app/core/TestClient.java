package tdt4140.gr1801.app.core;


import junit.framework.TestCase;


public class TestClient extends TestCase{
	
	Client client;
	PersonalTrainer pt;
	Nutrition n1, n2, n3, n4;
	String date, date1, date2, date3, date4, date5;
	

	protected void setUp() {
		date = "20180101-1400";
		date1 ="20180102-1400";
		date2 ="20180103-1400";
		date3 ="20180104-1400";
		date4 ="20180105-1400";
		date5 ="20190106-1400";
		
		n1 = new Nutrition(date1, 1887, 63, 94, 236, 1);
		n2 = new Nutrition(date2, 1688, 62, 78, 203, 1);
		n3 = new Nutrition(date3, 1887, 63, 94, 236, 1);  
		n4 = new Nutrition(date4, 1688, 62, 78, 203, 1);
		
		pt = new PersonalTrainer("Vilde123", "Halvor", "Nilsen", "Halvor@nilsen.com","90911287",date);
		client = new Client(1,"Vilde",170,pt);
		client.addNutrition(n1);
		client.addNutrition(n2);
		client.addNutrition(n3);
		client.addNutrition(n4);
		
		client.addFat(date1,0.2);
		client.addFat(date2,0.21);
		client.addFat(date3,0.22);
		client.addFat(date4,0.21);
		
		client.addWeight(date1,56);
		client.addWeight(date2,56.5);
		client.addWeight(date3,57);
		client.addWeight(date4,57.2);
	}
	
	public void testGetId() {
		assertEquals(1,client.getId());
	}
	
	public void testGetName() {
		assertEquals("Vilde", client.getName());
	}
	
	public void testGetHeight() {
		assertEquals(170, client.getHeight());
	}
	
	public void testGetPersonalTrainer() {
		assertEquals(this.pt.getUsername(), client.getPersonalTrainer());
	}
	
	public void testGetFat() {
		assertEquals(0.22, client.getFat(this.date3));
	}
	
	
	public void testExceptionsInGetFat() {
		try {
			Double fat = client.getFat(date5);
			fail();
		}
		catch (IllegalArgumentException IAE) {
		}
	}

	public void testGetWeight() {
		assertEquals(56.0, client.getWeight(date1));
	}
	
	public void testExceptionsInGetWeight() {
		try {
			client.getWeight(date5);
			fail();
		}
		catch (IllegalArgumentException IAE) {
		}
	}

	public void testGetNutrition() {
		assertEquals(n1,client.getNutrition(date1));
	}
	
	
	public void testExceptionsInGetNutrition() {
		try {
			client.getNutrition(date5);
			fail();
		}
		catch (IllegalArgumentException IAE) {
		}
	}

}	

