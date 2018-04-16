package tdt4140.gr1801.app.core;

import java.util.ArrayList;
import java.util.List;


// Class with methods and fields for an Exercise
public class Exercise {

	private String name;
	private double weight;	// In kg
	private List<Integer> repsPerSet = new ArrayList<>();	

	
	public Exercise(String name, double weight, List<Integer> repsPerSet) {
		checkArguments(name, weight, repsPerSet);
		this.name = name;
		this.weight = weight;
		this.repsPerSet = repsPerSet;
	}
	
	
	// Checking input-argument
	private void checkArguments(String name, double weight, List<Integer> repsPerSet) {
		if (name.length() <= 0 || name.chars().anyMatch(c -> !Character.isLetter(c) && c != ' ')) {
			throw new IllegalArgumentException("Name of exercise is not valid");
		}
		if (weight < 0) {
			throw new IllegalArgumentException("Weight cannot be negative");
		}
		if (repsPerSet.size() <= 0) {
			throw new IllegalArgumentException("List of reps per set must have at least one element");
		}
		if (repsPerSet.stream().anyMatch(r -> r < 0)) {
			throw new IllegalArgumentException("All reps must be nonnegative");
		}
	}
	
	
	// Getters:
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public List<Integer> getRepsPerSet(){
		return repsPerSet;
	}
	
	public int getNumberOfSets() {
		return repsPerSet.size();
	}
	
	public String getReps() {
		String r = "";
		for (int rep : repsPerSet) {
			r += rep + "-"; 
		}
		return r.substring(0, r.length()-1);
	}
	
	public int getTotalReps() {
		int total = 0;
		for (int reps : repsPerSet) {
			total += reps;
		}
		return total;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setRepsPerSet(List<Integer> repsPerSet) {
		this.repsPerSet = repsPerSet;
	}
}
