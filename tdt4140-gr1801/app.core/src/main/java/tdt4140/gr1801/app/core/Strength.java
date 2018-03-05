package tdt4140.gr1801.app.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Strength extends Training {
	
	private List<Exercise> exercises = new ArrayList<Exercise>();
	
	public Strength(Date date, int duration, List<Exercise> exercises) {
		super(date, duration);
		if (exercises.isEmpty()) {
			throw new IllegalArgumentException("Workout needs at least one exercise");
		}
		this.exercises = exercises;
	}
	
	public List<Exercise> getExercises() {
		return exercises;
	}

	public Exercise getSpecificExercise(String name) {	
		for (Exercise exercise : exercises) {
			if (exercise.getName().equals(name)) {
				return exercise;
			}
		}
		throw new IllegalArgumentException("Unvalid exercise");
	}
}
