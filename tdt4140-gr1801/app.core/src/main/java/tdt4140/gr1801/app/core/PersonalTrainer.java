package tdt4140.gr1801.app.core;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import javafx.scene.control.TextField;
import tdt4140.gr1801.web.server.GetURL;
import tdt4140.gr1801.web.server.LoginModule;

public class PersonalTrainer {
	
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	private String birthday;
	
	private ArrayList<Client> clientList = new ArrayList<>();
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthday() {
		return birthday;
	}
	

	public PersonalTrainer(String username, String firstName, String lastName, String email, String phoneNumber, String password, String birthday) {
		//if(!checkNames(firstName, lastName)) {
		//	throw new IllegalArgumentException("Invalid names. Only letters.");
		//}
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.password = password;
	}
	
	public PersonalTrainer() {
		
	}
	
	public static boolean checkUsername(String username) {
		return username.matches("[A-Za-z0-9]+");
	}
	
	
	//First and last name must only consist of letters. Can allow symbols as well if we find it necessary.
	public static boolean checkFirstName(String firstName) {
		return (firstName.matches("[a-zA-Z]+"));
	}
	
	public static boolean checkLastName(String lastName) {
		return (lastName.matches("[a-zA-Z]+"));
	}
	
	
	//Assumes all types of Norwegian phone numbers. Must contain 8 numbers.
	public static boolean checkPhoneNumber(String phoneNumber) {
		return (phoneNumber.length() == 8 && phoneNumber.matches("[0-9]+"));
	}
	
	public static boolean checkEmail(String email) {
		return email.contains("@");
	}
	
	public static ArrayList<Boolean> checkAllFields(ArrayList<TextField> fields) {
		ArrayList<Boolean> correctness = new ArrayList<Boolean>();
		correctness.add(checkUsername(fields.get(0).getText()));
		correctness.add(checkFirstName(fields.get(1).getText()));
		correctness.add(checkLastName(fields.get(2).getText()));
		correctness.add(checkPhoneNumber(fields.get(3).getText()));
		correctness.add(checkEmail(fields.get(4).getText()));
		return correctness;		
	}
	
	public void addClient(Client client) throws IllegalArgumentException{
		if(clientList.contains(client)) {
			throw new IllegalArgumentException("Client already in client list");
		}
		clientList.add(client);
	}

	 
	public void removeClient(Client client) {
		if(!clientList.contains(client)) {
			throw new IllegalArgumentException("Client is not in client list");
		}
		clientList.add(client);
	}
	
	public Client getClient(Client client) throws IllegalArgumentException{
		if(!clientList.contains(client)) {
			throw new IllegalArgumentException("This client is not in client list");
		}
		return client;
	}
	
	// OPPRETTELSE AV PT I DB:
	//Metode som setter inn en PT i databasen - skal denne legges inn i konstruktoeren til PT. 
	public void createPT(String passwrd) throws IOException {
		JSONObject json = new JSONObject();
		json.put("PT_ID", this.username);
		//Hasher passord. Kan kanskje gjoeres et annet sted.
		json.put("Passwrd", LoginModule.hashSha256(passwrd));
		json.put("Navn", this.firstName+" "+this.lastName);
		json.put("Email", this.email);
		json.put("Birthday", this.birthday);
		json.put("Phonenr", this.phoneNumber);
		System.out.println(json);
		String respons = GetURL.postRequest("/signup/pt", json);
		System.out.println(respons);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		PersonalTrainer pt = new PersonalTrainer("vildera","Vilde", "Arntzen", "vildera@stud.ntnu.no","90959409","henrikerkul","19970603");
		System.out.println(pt.password);
		pt.createPT("henrikerkul");
	}
}
