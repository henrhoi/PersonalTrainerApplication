package tdt4140.gr1801.app.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise {
	
	private String name;
	private double weight;
	private List<Integer> repsPerSet = new ArrayList<>();

	// Each index corresponds to one single set, while the value corresponds to number of reps in this set.  
	// [  10  ,  8   ,  6  , ... ]
	//   Set1   Set2   Set3  ...
	// TODO: Better ways to do this?
	// TODO: Weight is not always constant throughout all sets
	
	public Exercise(String name, double weight, List<Integer> repsPerSet) {
		checkArguments(name, weight, repsPerSet);
		this.name = name;
		this.weight = weight;
		this.repsPerSet = repsPerSet;
	}
	
	
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
	
	
	
	/*
	public static void main(String[] args) {
		Exercise e = new Exercise("Benchpress on bench", 80, Arrays.asList(10, 10, 7));
		System.out.println("Success");
	}
	*/
	
}