package tdt4140.gr1801.app.core;

import java.util.Date;




public abstract class Training {
	
	protected Date date;
	protected int duration; // In minutes
	
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
