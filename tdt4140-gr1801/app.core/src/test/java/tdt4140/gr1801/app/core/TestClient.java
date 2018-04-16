package tdt4140.gr1801.app.core;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import junit.framework.TestCase;

public class TestClient extends TestCase{
	
	Client client;
	PersonalTrainer pt;
	Nutrition n1, n2, n3, n4;
	String date, date1, date2, date3, date4, date5;
	List<String> dates;
	

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
		
		pt = new PersonalTrainer("Vilde123", "Halvor", "Nilsen", "Halvor@nilsen.com","90911287", "20180227-xxxx");
		client = new Client(1,"Vilde",170,pt,200);
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
		
		
		
		dates = new ArrayList<String> ();
		dates.add("2018-04-04");
		dates.add("2018-05-05");
	}
	
	public void testClient() {
		Client clientTest = new Client(90,"Henrik",189,pt);
		assertEquals(clientTest.getId(),90);
		assertEquals(clientTest.getPersonalTrainer(),pt.getUsername());
		assertEquals(clientTest.getHeight(),189);
		assertEquals(clientTest.getPersonalTrainerObject(),pt);
	}
	
	public void testGetId() {
		assertEquals(client.getId(),1);
	}
	
	public void testGetName() {
		assertEquals(client.getName(),"Vilde");
	}
	
	public void testGetHeight() {
		assertEquals(Client.checkHeight(client.getHeight()),true);
	}
	
	public void testGetPersonalTrainer() {
		assertEquals(client.getPersonalTrainer(),this.pt.getUsername());
	}
	
	public void testGetPersonalTrainerObject(){
		assertEquals(client.getPersonalTrainerObject(),this.pt);
	}
	
	public void testGetWeight() {
		assertEquals(client.getWeight(date1),56.0);
	}
	
	public void testExceptionsInGetWeight() {
		try {
			client.getWeight(date5);
			fail();
		}
		catch (IllegalArgumentException IAE) {
		}
	}
	
	public void testGetStrengthList() {
		List<Exercise> testExercises = new ArrayList<Exercise>();
		List<Integer> rep = new ArrayList<Integer>();
		rep.add(2); rep.add(3);
		Exercise e = new Exercise("Hopp", 0.5, rep);
		testExercises.add(e);
		Strength e1 = new Strength("20180101-1400",4,testExercises);
		Strength e2 = new Strength("20180101-1500",30,testExercises);
		List<Strength> testList = new ArrayList<Strength>();
		testList.add(e1);
		testList.add(e2);
		client.addStrengthTraining(e1);
		client.addStrengthTraining(e2);
		assertEquals(client.getStrengthList(),testList);
	}

	public void testGetEnduranceList() {
		Endurance e1 = new Endurance("20180101-1400",4,0.5,4,5,6);
		Endurance e2 = new Endurance("20180101-1500",2,0.5,4,5,6);
		List<Endurance> testList = new ArrayList<Endurance>();
		testList.add(e1);
		testList.add(e2);
		client.addEnduranceTraining(e1);
		client.addEnduranceTraining(e2);
		assertEquals(client.getEnduranceList(),testList);
	}
	
	public void testGetNutritionList() {
		List<Nutrition> testList = new ArrayList<Nutrition>();
		testList.add(n1);
		testList.add(n2);
		testList.add(n3);
		testList.add(n4);
		assertEquals(client.getNutritionList(),testList);
	}
	
	// Axel 
	public void testGetDayProgramList() {
		// legg til kode
	}
	
	public void testGetWeightMap() {
		assertEquals(client.getWeightMap().get(date1),56.0);
	}
	
	public void testGetFatMap() {
		assertEquals(client.getFatMap().get(date1),0.2);
	}
	
	public void testGetFat() {
		assertEquals(client.getFat(this.date3),0.22);
	}
	
	public void testExceptionsInGetFat() {
		try {
			@SuppressWarnings("unused")
			Double fat = client.getFat(date5);
			fail();
		}
		catch (IllegalArgumentException IAE) {
		}
	}
	
	public void testGetNutrition() {
		assertEquals(client.getNutrition(date1),n1);
	}
	
	public void testExceptionsInGetNutrition() {
		try {
			client.getNutrition(date5);
			fail();
		}
		catch (IllegalArgumentException IAE) {
		}
	}
	
	
	
	public void testGetMaxPulse() {
		assertEquals(client.getMaxPulse(),200);
	}
	
	public void testAddWeight() {
		try {
			client.addWeight(date1, -20);
			fail();
		}
		catch (IllegalArgumentException IAE) {
		}
	}
	
	public void testAddFat() {
		try {
			client.addFat(date1, -1.0);
			fail();
		}
		catch (IllegalArgumentException IAE) {
		}
	}
	
	public void testAddNutrition() {
		Nutrition n5 = new Nutrition("20180101-1400",1688, 62, 78, 203, 1);
		client.addNutrition(n5);
		assertEquals(client.getNutritionList().contains(n5),true);
	}
	
	public void testAddStrengthTraining() {
		List<Exercise> testExercises = new ArrayList<Exercise>();
		List<Integer> rep = new ArrayList<Integer>();
		rep.add(2); rep.add(3);
		Exercise e = new Exercise("Hopp", 0.5, rep);
		testExercises.add(e);
		Strength e1 = new Strength("20180101-1400",4,testExercises);
		Strength e2 = new Strength("20180101-1500",30,testExercises);
		Strength test = new Strength("20180101-1400",30, testExercises);
		client.addStrengthTraining(test);
		assertEquals(client.getStrengthList().contains(test),true);
	}
 
	public void testAddEnduranceTraining() {
		Endurance test = new Endurance("20180101-1400",5,10,300,5,6);
		client.addEnduranceTraining(test);
		assertEquals(client.getEnduranceList().contains(test),true);
	}
	
	public void testCheckName() {
		assertEquals(Client.checkFirstName(client.getName()),true);
		assertEquals(Client.checkLastName(client.getName()),true);
	}
	
	public void testCheckMaxpulse() {
		assertTrue(client.checkmaxPulse(180));
		assertFalse(client.checkmaxPulse(800));
	}
	
	
	
	
	
	public void testCheckHeight() {
		assertTrue(client.checkHeight(170));
		assertFalse(client.checkHeight(-900));
	}
	
		
		
		
	public void testToString() {
		assertEquals(this.client.getName(),client.toString());
	}
	
}	

