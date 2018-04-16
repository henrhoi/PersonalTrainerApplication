package tdt4140.gr1801.web.server;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

// Module with methods used for logging in and password handling.
public class LoginModule {

	
	// Method that cross-checks input password with password stored in database
	// Returnes a boolean value whether or not the input passord is correct
	public static boolean checkLogin(String username, String password) throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		String shaHashedPasswrd;
		
		// Getting the users login-information, personal salt and sha-hashed password, with a GET-request
		String content = GetURL.getRequest("/login/"+username);
		
		// Checking whether the username was in the database or not. The json-file should be emtpy, "[]" if the user does not exists
		if (content.equals("[]")) {return false;}
		
		// Retreiving the salt and password from the json-file 
		JSONObject json = new JSONObject(content);
		String salt = json.getString("Salt");
		String passwrd = json.getString("Passwrd");
		
		// Hashing input password
		shaHashedPasswrd = hashSha256(password, salt);
		
	    // Returning whether or not the password corresponds with the password in the database
		return passwrd.equals(shaHashedPasswrd);
		
	}
	
	// Method that hashes the input strings, with SHA256
	public static String hashSha256(String string, String salt) {
		try{
			string += salt;
			
			//Hashing the composition of input strings
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(string.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        	//Converting the hex string to a string consisting of ASCII-characters
	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	        
	        // Returning SHA256-hashed string 
	        return hexString.toString();
	        
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	// Static method that generates a random salt
	// It is used in PersonalTrainer.java when creating a new PT
	public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
    }
	
}
