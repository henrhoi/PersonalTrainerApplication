package tdt4140.gr1801.app.core;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;

import javafx.scene.control.TextField;
import tdt4140.gr1801.web.server.GetURL;
import tdt4140.gr1801.web.server.LoginModule;

public class PersonalTrainer {
	
	private String username;
	private String name;
	private String email;
	private String phoneNumber;
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

	public String getName() {
		return this.name;
	}

	public String getBirthday() {
		return birthday;
	}
	

	public PersonalTrainer(String username, String firstName, String lastName, String email, String phoneNumber, String birthday) {
		//if(!checkNames(firstName, lastName)) {
		//	throw new IllegalArgumentException("Invalid names. Only letters.");
		//}
		this.username = username;
		this.name = firstName + " " + lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public PersonalTrainer() {
		
	}
	
	// Konstruktør som tar inn PT_ID som input, returnerer et PT-objekt fra DB, dersom brukernavnet er gyldig
	public PersonalTrainer(String username) throws ClientProtocolException, IOException {
		String data = GetURL.getRequest("/pt/"+username);
		JSONObject json = new JSONArray(data).getJSONObject(0);
		this.username = username;
		this.name = json.getString("Navn");
		this.email = json.getString("Email");
		this.phoneNumber = json.getString("Phonenr");
		this.birthday = json.getString("Birthday");
		
	}
	
	public static boolean checkUsername(String username) {
		//TODO check if username is taken i database.
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
	public void createPT(String passwrd) throws IOException  {
		JSONObject json = new JSONObject();
		String salt = LoginModule.generateSalt();
		json.put("PT_ID", this.username);
		//Hasher passord. Kan kanskje gjoeres et annet sted.
		json.put("Passwrd", LoginModule.hashSha256(passwrd, salt));
		json.put("Salt", salt);
		json.put("Navn", this.name);
		json.put("Email", this.email);
		json.put("Birthday", this.birthday);
		json.put("Phonenr", this.phoneNumber);
		System.out.println(json);
		String respons = GetURL.postRequest("/signup/pt", json);
		System.out.println(respons);
	}
	
	
	// TODO - må teste denne
	public void getPTClients() throws ClientProtocolException, IOException {
		String data = GetURL.getRequest("/client/all/"+this.username);
		JSONArray json = new JSONArray(data);
		for (int n = 0; n < json.length(); n++) {
			JSONObject object = json.getJSONObject(n);
			String navn = object.getString("Navn");
			int id = object.getInt("ClientID");
			int height = object.getInt("Height");

			Client newClient = new Client(id, navn, height, this);
		}
	}
	
	
	// Main som tester at PT får sine klienter.
	public static void main(String[] args) throws IOException {
		PersonalTrainer pt = new PersonalTrainer("henrhoi","Vilde", "Arntzen", "vildera@stud.ntnu.no","90959409","19970603");
		pt.getPTClients();
		for (Client client : pt.clientList) {
			System.out.println(client.getName());
		}
		
		PersonalTrainer pt1 = new PersonalTrainer("henrhoi");
		System.out.println(pt1.birthday);
	}
}
