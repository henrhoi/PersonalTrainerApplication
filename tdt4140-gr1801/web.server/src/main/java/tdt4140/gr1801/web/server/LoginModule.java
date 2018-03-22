package tdt4140.gr1801.web.server;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;


public class LoginModule {
	
	// Metode som krysssjekker innputtet passord med passord i database:
	public static boolean checkLogin(String username, String password) throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		String shaHashedPasswrd;
		// for naa for enkelhetsskyld, slik at det skal vaere enklere for en utenforstaaende og kjoere funksjonen.
		
		// Legger til salt, som burde ha vaert hemmelig. 
		String content = GetURL.getRequest("/login/"+username);
		
		// No PT with that username
		if (content.equals("[]")) {return false;}
		
		JSONObject json = new JSONObject(content);
		String salt = json.getString("Salt");
		String passwrd = json.getString("Passwrd");
		
		// Hasher passordet
		shaHashedPasswrd = hashSha256(password, salt);
		
		


		//System.out.println(content);
		
	    // Returnerer om passordet som proeves aa logge inn med stemmer med passordet i databasen. 
		return passwrd.equals(shaHashedPasswrd);
		
	}
	
	public static String hashSha256(String string, String salt) {
		try{
			// Definerer et salt. Burde ha vaert en envirement variabel (setenv), men lar den ligge i koden
			// for naa for enkelhetsskyld, slik at det skal vaere enklere for en utenforstaaende og kjoere funksjonen.
			// Legger til salt, som burde ha vaert hemmelig. 
			string += salt;
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(string.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	        
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	// Brukes i PersonalTrainer.java, for oppsetting av ny PT.
	public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
    }
	
	
	
	// Main som tester om passordet til PT-brukeren 'henrhoi' er 'puerbest' 
	public static void main(String[] args) throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		//System.out.println(LoginModule.generateSalt());
		//String passord = "fortnite123";
		//String salt = "mLTYw6QIg7AeCw4vA2uN+Fxcm3g=";
		//System.out.println(LoginModule.hashSha256(passord, salt));
		boolean test = checkLogin("henrhoi","puerbest");
		System.out.println(test);
	}


}
