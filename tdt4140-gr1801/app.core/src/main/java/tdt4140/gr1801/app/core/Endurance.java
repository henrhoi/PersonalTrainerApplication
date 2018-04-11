package tdt4140.gr1801.app.core;

public class Endurance extends Training implements Comparable<Endurance>{


	private double distance; // In km
	private double averageSpeed; // In km/h
	private int caloriesBurned;
	private int maxPulse;
	private int avgPulse;

	public Endurance(String date, int duration, double distance, int caloriesBurned, int maxPulse, int avgPulse) {
		super(date, duration);
		if (distance < 0) {
			throw new IllegalArgumentException("Distance cannot be negative");
		}
		if (caloriesBurned < 0) {
			throw new IllegalArgumentException("Calories burned cannot be negative");
		}
		this.distance = distance;
		this.averageSpeed = distance/((double)(duration)/60);
		this.caloriesBurned = caloriesBurned;
		this.maxPulse = maxPulse;
		this.avgPulse = avgPulse;
		
	}
	
	public double getDistance() {
		return distance;
	}
	
	public double getAverageSpeed() {
		return averageSpeed;
	}
	
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	
	public int getMaxPulse() {
		return maxPulse;
	}
	
	public int getAvgPulse() {
		return avgPulse;
	}

	@Override
	public int compareTo(Endurance o) {
		return getDate().compareTo(o.getDate());
	}
	
}
