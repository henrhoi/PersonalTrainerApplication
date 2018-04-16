package tdt4140.gr1801.app.core;

import java.util.Arrays;
import java.util.List;

public class DayProgram implements Comparable<DayProgram>{
	
	
	private String weekday;
	
	// For Endurance
	private Integer duration;
	private Double distance;
	private Double avgSpeed;
	private String description;
	
	// For Strength
	List<Exercise> exercises;
	
	
	public DayProgram(String weekday, Integer duration, Double distance, Double avgSpeed, String description,
			List<Exercise> exercises) {
		this.weekday = weekday;
		this.duration = duration;
		this.distance = distance;
		this.avgSpeed = avgSpeed;
		this.description = description;
		this.exercises = exercises;
	}


	public String getWeekday() {
		return weekday;
	}

	public Integer getDuration() {
		return duration;
	}


	public Double getDistance() {
		return distance;
	}


	public Double getAvgSpeed() {
		return avgSpeed;
	}


	public String getDescription() {
		return description;
	}


	public List<Exercise> getExercises(){
		return exercises;
	}
	

	@Override
	public String toString() {
		return weekday;
	}


	@Override
	public int compareTo(DayProgram o) {
		List<String> weekdays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
		return weekdays.indexOf(this.getWeekday()) - weekdays.indexOf(o.getWeekday());
	}
	

}
