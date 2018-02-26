package tdt4140.gr1801.app.core;

import java.util.Date;


//Superklasse for Endurance og Strength. Vil inneholde alt som er felles for disse
// Abstrakt da det ikke skal være mulig å instansiere rene Training-objekter

public abstract class Training {
	
	protected Date date;
	protected int duration; // I minutter
	
	public Training(Date date, int duration) {
		if (duration < 0) {
			throw new IllegalArgumentException("Duration cannot be negative");
		}
		this.duration = duration;
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getDuration() {
		return duration;
	
	}
	
	

}
