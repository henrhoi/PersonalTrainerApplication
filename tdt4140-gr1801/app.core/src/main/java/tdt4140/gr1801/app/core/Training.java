package tdt4140.gr1801.app.core;


//Superclass for Endurance and Strength. Will contain everything that is common for those two. 
//Is abstract since it should not be possible to instantiate a Training-object on its own.

public abstract class Training {

	//Date format "yyyymmdd-xxxx"

	protected String date;
	protected int duration; // In minutes
	
	public Training(String date, int duration) {
		if (duration < 0) {
			throw new IllegalArgumentException("Duration cannot be negative");
		}
		this.duration = duration;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public int getDuration() {
		return duration;
	}
	
	

}
