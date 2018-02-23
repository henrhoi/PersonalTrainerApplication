package tdt4140.gr1801.app.core;

import java.util.ArrayList;
import java.util.Date;

import javafx.scene.control.TextField;

public class PersonalTrainer {
	
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date birthday;
	
	//private ArrayList<Client> clientList;
	
	public PersonalTrainer(String username, String firstName, String lastName, String email, String phoneNumber, Date birthday) {
		if(!checkUsername(username)) {
			throw new IllegalStateException("Invalid username.");
		}
		//if(!checkNames(firstName, lastName)) {
		//	throw new IllegalArgumentException("Invalid names. Only letters.");
		//}
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public PersonalTrainer() {
		
	}
	
	//Username cannot be longer than 15 characters
	public boolean checkUsername(String username) {
		return username.length() > 15;
	}
	
	
	//First and last name must only consist of letters. Can allow symbols as well if we find it necessary.
	public boolean checkFirstName(String firstName) {
		return (firstName.matches("[a-zA-Z]"));
	}
	
	public boolean checkLastName(String lastName) {
		return (lastName.matches("[a-zA-Z]"));
	}
	
	
	//Assumes all types of Norwegian phone numbers. Must contain 8 numbers.
	public boolean checkPhoneNumber(String phoneNumber) {
		return !(phoneNumber.length() == 8);
	}
	
	public boolean checkEmail(String email) {
		return true;
	}
	
	public ArrayList<Boolean> checkAllFields(ArrayList<TextField> fields) {
		ArrayList<Boolean> correctness = new ArrayList<Boolean>();
		correctness.add(checkUsername(fields.get(0).getText()));
		correctness.add(checkFirstName(fields.get(1).getText()));
		correctness.add(checkLastName(fields.get(2).getText()));
		correctness.add(checkPhoneNumber(fields.get(3).getText()));
		correctness.add(checkEmail(fields.get(4).getText()));
		return correctness;
		
		
	}
	
	
	
	
}
