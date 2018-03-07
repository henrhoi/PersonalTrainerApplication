package tdt4140.gr1801.app.core;

import java.util.Date;

public class Nutrition {
	
	private Date date; 
	//everything measured in grams: 
	private Integer calories; 
	private Integer fat; 
	private Integer carbs;
	private Integer protein; 
	
	
	public Nutrition(Date date, int calories, int fat, int carbs, int protein) {
		this.date = date;
		this.calories = calories;
		this.fat = fat; 
		this.carbs = carbs;
		this.protein = protein; 
	}
	
	public Date getDate() {
		return date; 
	}
	
	public int getCalories() {
		return calories;
	}
	
	public int getFat() {
		return fat;
	}
	
	public int getCarbs() {
		return carbs;
	}
	
	public int getProtein() {
		return protein;
	}
	

}
