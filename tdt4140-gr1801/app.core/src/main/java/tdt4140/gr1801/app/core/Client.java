package tdt4140.gr1801.app.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {
    private String name;
    
    private int id;
    private int height;
    private PersonalTrainer pt;
    private HashMap<String,Double> weights; // measured in float (kg)
    private HashMap<String,Double> fats; // measured in float [0,1]
    private List<Nutrition> nutritions;
    
    
    private List<Strength> strengthTraining;
    private List<Endurance> enduranceTraining;
    
    
    public Client(int id, String name, int height, PersonalTrainer pt) {
	    this.id = id;
	    this.name = name;
	    this.height = height;
	    this.pt = pt;
	    
	    this.weights = new HashMap<String,Double>();
	    this.fats = new HashMap<String,Double>();
	    this.nutritions = new ArrayList<Nutrition>();
	    this.strengthTraining = new ArrayList<Strength>();
	    this.enduranceTraining = new ArrayList<Endurance>();
    }
    
    
    public int getId() {
    		return id;
    }
    
    public String getName() {
    		return name;
    }
    
    public int getHeight() {
    		return height;
    }
    
    public String getPersonalTrainer() {
    		return pt.getUsername();
    }
    
    public Double getWeight(String date){
    		if (this.weights.containsKey(date)) {
    			return this.weights.get(date);
    		} else {
    			throw new IllegalArgumentException("No weight registered for this date");
    		}
    }
    
    
    public Double getFat(String date){
    		if (this.fats.containsKey(date)) {
    			return this.fats.get(date);
    		} else {
    			throw new IllegalArgumentException("No fat percent registered for this date");
    		}
    }
    
    
    
    
    public Nutrition getNutrition(String date) {
    		for (Nutrition nutrition : nutritions) {
    			if (nutrition.getDate().equals(date)){
				return nutrition;
    			}
    		} throw new IllegalArgumentException("No nutrition registered for this date");
    }
    
    
    //kan legge til metode for å endre pt for klient, må da legge til
    // metode i pt som fjerner klient fra pt også
    
    
    public void addWeight(String date, double weight) {
    		if (weight>0 && weight<400) {
    			this.weights.put(date, weight);
    		}else {
    			throw new IllegalArgumentException("Not valid weight, must be in range [0,400]");
    		}
    }
    
    
    public void addFat(String date, Double fat) {
    		if (fat>0 && fat<1) {
    			this.fats.put(date,fat);
    		}else {
    			throw new IllegalArgumentException("Not valid fat percent, must be in range [0,1]");
    		}
    }
    
    
    // Burde mulig ha en sjekk her for om datoen allerede eksisterer?
    // for-løkke?
    public void addNutrition(Nutrition nutrition) {
    		this.nutritions.add(nutrition);
    }
}
