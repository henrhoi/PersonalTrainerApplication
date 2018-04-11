package tdt4140.gr1801.app.core;


public class Nutrition {
	
	//Date format "yyyymmdd-xxxx"
	private String date; 
	//everything measured in grams: 
	private Integer calories; 
	private Integer fat; 
	private Integer carbs;
	private Integer protein; 
	private Integer clientId;
	
	public Nutrition(String date, int calories, int fat, int carbs, int protein, int clientId) {
		// There are 4 calories per 1 gram carbs,
		// There are 4 calories per 1 gram protein,
		// There are 9 calories per 1 gram fat
		this.clientId = clientId;
		//if ((9*fat + 4*carbs + 4*protein)==calories) {
		this.date = date;
		this.calories = calories;
		this.fat = fat; 
		this.carbs = carbs;
		this.protein = protein; 
		/*} else {
			throw new IllegalArgumentException("Calories don´t match grams of fat, carbs and proteins.");
		}*/
	}
	
	public String getDate() {
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
	
	public int getClientId() {
		return clientId;
	}
	
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
