package tdt4140.gr1801.app.core;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
	
	private String name;
	private double weight;
	private List<Integer> repsPerSet = new ArrayList<>();
	// Tanken her er at hver indeks tilsvarer ett sett, mens verdien (tallet) på indeksplassen tilsvarer antall reps dette settet. 
	// [  10  ,  8   ,  6  , ... ]
	//   Set1   Set2   Set3  ...
	// TODO: Bedre måter å gjøre dette på??
	// TODO: Skal vi ta hensyn til at vekten ikke må være lik for hvert sett?
	
	
	public Exercise(String name, double weight, List<Integer> repsPerSet) {
		checkArguments(name, weight, repsPerSet);
		this.name = name;
		this.weight = weight;
		this.repsPerSet = repsPerSet;
	}
	
	
	private void checkArguments(String name, double weight, List<Integer> repsPerSet) {
		if (name.length() <= 0 || name.chars().anyMatch(c -> !Character.isLetter(c))) {
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
	
	public int getTotalReps() {
		int total = 0;
		for (int reps : repsPerSet) {
			total += reps;
		}
		return total;
	}
	
	public double getAverageReps() {
		return getTotalReps()/getNumberOfSets();
	}
	
	
	/*
	public static void main(String[] args) {
		Exercise e = new Exercise("Benkpress", 80, Arrays.asList(10, 10, 7));
		System.out.println("Success");
	}
	*/
	
	
	

}
