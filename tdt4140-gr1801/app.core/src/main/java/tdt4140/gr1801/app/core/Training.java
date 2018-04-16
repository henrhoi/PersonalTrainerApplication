package tdt4140.gr1801.app.core;

//Superclass for Endurance and Strength. Will contain everything that is common for those two. 
//Is abstract since it should not be possible to instantiate a Training-object on its own.

public abstract class Training {

	protected String date;  //Date format: "yyyymmdd-xxxx"
	protected int duration; // In minutes
	
	
	public Training(String date, int duration) {
		// Checking if duration valid
		if (duration < 0) {
			throw new IllegalArgumentException("Duration cannot be negative");
		}
		this.duration = duration;
		this.date = date;
	}

	
	// Getters:
	public String getDate() {
		return date;
	}

	public int getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		String year = date.substring(0, 4);
		String day = date.substring(8);
		switch(date.substring(5, 7)) {
		case "01": return day + ". Jan " + year;
		case "02": return day + ". Feb " + year;
		case "03": return day + ". Mar " + year;
		case "04": return day + ". Apr " + year;
		case "05": return day + ". May " + year;
		case "06": return day + ". Jun " + year;
		case "07": return day + ". Jul " + year;
		case "08": return day + ". Aug " + year;
		case "09": return day + ". Sep " + year;
		case "10": return day + ". Oct " + year;
		case "11": return day + ". Nov " + year;
		case "12": return day + ". Des " + year;
		default: return "";
		}
	}
	

	

}
