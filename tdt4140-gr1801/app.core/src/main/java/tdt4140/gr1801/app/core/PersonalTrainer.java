package tdt4140.gr1801.app.core;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
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
		this.username = username;
		this.name = firstName + " " + lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public PersonalTrainer() {
		
	}
	// constructor that has PT_ID as input and returns a PT-object from the database if the username is valid
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
		return username.matches("[A-Za-z0-9]+");
	}
	
	
	// first and last name must only consist of letters. Can allow symbols as well if we find it necessary.
	public static boolean checkFirstName(String firstName) {
		return (firstName.matches("[a-zA-Z]+"));
	}
	
	public static boolean checkLastName(String lastName) {
		return (lastName.matches("[a-zA-Z]+"));
	}
	
	// assumes all types of Norwegian phone numbers. Must contain 8 numbers.
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
		clientList.remove(client);
	}
	
	public Client getClient(Client client) throws IllegalArgumentException{
		if(!clientList.contains(client)) {
			throw new IllegalArgumentException("This client is not in client list");
		}
		return client;
	}
	
	public ArrayList<Client> getClientList(){
		return this.clientList;
	}
	
	
	
	// creating PersonalTrainer in the database
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
		GetURL.postRequest("/signup/pt", json);
	}
	
	
	public void deleteClient(String passwrd, int clientID) throws IOException, NoSuchAlgorithmException, JSONException {
		JSONObject json = new JSONObject();
		json.put("PT_ID", this.username);
		json.put("Passwrd", passwrd);
		json.put("ClientID", clientID);
		String respons = GetURL.postRequest("/client/remove", json);
		for(Client client : clientList) {
			if(client.getId() == clientID){
				clientList.remove(client);
				break;
			}
		}
	}
	
	public void getPTClients() throws ClientProtocolException, IOException {
		String data = GetURL.getRequest("/client/all/"+this.username);
		JSONArray json = new JSONArray(data);
		for (int n = 0; n < json.length(); n++) {
			JSONObject object = json.getJSONObject(n);
			String navn = object.getString("Navn");
			int id = object.getInt("ClientID");
			int height = object.getInt("Height");
			int maxPulse = object.getInt("MaxPulse");
			// comment that removes error that client is never used
			@SuppressWarnings("unused")
			Client client = new Client(id, navn, height, this, maxPulse);
		}
	}
	
	public Boolean changePassword(String password, String new_password) throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		if (LoginModule.checkLogin(this.getUsername(), password)) {
			JSONObject json = new JSONObject();
			String salt = LoginModule.generateSalt();
			json.put("PT_ID", this.username);
			json.put("Passwrd", LoginModule.hashSha256(new_password, salt));
			json.put("Salt", salt);
			GetURL.postRequest("/pt/changepassword", json);
		}
		return false;
	}
}
