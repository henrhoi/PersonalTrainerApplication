package tdt4140.gr1801.app.core;

import java.util.Date;
import java.util.HashMap;

public class Client {
	private String firstName;
	private String lastName;
	private int id; 
	private HashMap<Date,Double> weight; // measured in float (kg) 
	private HashMap<Date,Double> fat; // measured in float [0,1]
	private PersonalTrainer pt;

	public Client(String firstName, String lastName, int id, PersonalTrainer pt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.weight = new HashMap<Date,Double>();
		this.fat = new HashMap<Date,Double>();
		this.pt = pt;
	}
	
	
	
	public String getFullName() {
		return ""+firstName+" "+lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public String getPersonalTrainer() {
		return pt.getUsername();
	}
	
	
	public void addWeight(Date date, double weight) {
		if (weight>0 && weight<400) {
			this.weight.put(date, weight);
		}else {
			throw new IllegalArgumentException("Not valid weight, must be in range [0,400]");
		}
	}
	// 
}
