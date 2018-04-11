package tdt4140.gr1801.app.core;

public class DayProgram {
	
	
	private String weekday;
	
	// For Endurance
	private Integer duration;
	private Double distance;
	private Double avgSpeed;
	private String description;
	
	// For Strength
	private String exerciseName;
	private Double weight;
	private Integer sets;
	private String reps;
	
	
	public DayProgram(String weekday, Integer duration, Double distance, Double avgSpeed, String description,
			String exerciseName, Double weight, Integer sets, String reps) {
		this.weekday = weekday;
		this.duration = duration;
		this.distance = distance;
		this.avgSpeed = avgSpeed;
		this.description = description;
		this.exerciseName = exerciseName;
		this.weight = weight;
		this.sets = sets;
		this.reps = reps;
	}


	public String getWeekday() {
		return weekday;
	}


	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public Double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public Double getAvgSpeed() {
		return avgSpeed;
	}


	public void setAvgSpeed(double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getExerciseName() {
		return exerciseName;
	}


	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public Integer getSets() {
		return sets;
	}


	public void setSets(int sets) {
		this.sets = sets;
	}


	public String getReps() {
		return reps;
	}


	public void setReps(String reps) {
		this.reps = reps;
	}
	

	@Override
	public String toString() {
		return weekday;
	}
	

}
