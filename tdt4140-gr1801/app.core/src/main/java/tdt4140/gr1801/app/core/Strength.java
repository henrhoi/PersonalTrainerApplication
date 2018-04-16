package tdt4140.gr1801.app.core;

import java.util.ArrayList;
import java.util.List;

// Class with methods and fields for Strength
public class Strength extends Training implements Comparable<Strength> {
	
	private List<Exercise> exercises = new ArrayList<Exercise>();
	
	
	public Strength(String date, int duration, List<Exercise> exercises) {
		super(date, duration);
		
		//Checking whether or not the exercise-list is empty
		if (exercises.isEmpty()) {
			throw new IllegalArgumentException("Workout needs at least one exercise");
		}
		this.exercises = exercises;
	}
	
	
	public List<Exercise> getExercises() {
		return exercises;
	}

	// Returnes an exercise in Exercise-list by Exercise-name
	public Exercise getSpecificExercise(String name) {	
		for (Exercise exercise : exercises) {
			if (exercise.getName().equals(name)) {
				return exercise;
			}
		}
		throw new IllegalArgumentException("Unvalid exercise");
	}

	@Override
	public int compareTo(Strength o) {
		return this.getDate().compareTo(o.getDate());

	}
}
