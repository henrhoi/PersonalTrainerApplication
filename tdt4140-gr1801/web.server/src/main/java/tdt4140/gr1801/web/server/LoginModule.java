package tdt4140.gr1801.web.server;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.http.client.ClientProtocolException;


public class LoginModule {
	
	// Metode som krysssjekker innputtet passord med passord i database:
	public static boolean checkLogin(String username, String password) throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		String shaHashedPasswrd;
		// Definerer et salt. Burde ha vaert en envirement variabel (setenv), men lar den ligge i koden
		// for naa for enkelhetsskyld, slik at det skal vaere enklere for en utenforstaaende og kjoere funksjonen.
		
		// Legger til salt, som burde ha vaert hemmelig. 

		// Hasher passordet
		shaHashedPasswrd = hashSha256(password);
		
		String content = GetURL.getRequest("/login/"+username);
		System.out.println(content);
		
	    // Returnerer om passordet som proeves aa logge inn med stemmer med passordet i databasen. 
		return content.equals(shaHashedPasswrd);
		
	}
	
	public static String hashSha256(String string) {
		try{
			// Definerer et salt. Burde ha vaert en envirement variabel (setenv), men lar den ligge i koden
			// for naa for enkelhetsskyld, slik at det skal vaere enklere for en utenforstaaende og kjoere funksjonen.
			String salt = "QxLUF1bgIAdeQX";

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
	
	
	
	// Main som tester om passordet til PT-brukeren 'henrhoi' er 'puerbest' 
	public static void main(String[] args) throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		boolean test = checkLogin("henrhoi","puerbest");
		System.out.println(test);
	}
	//TODO - SHA-256 - Done
	//TODO - Boolean funksjon for aa skjekke username og passord - Done
	//TODO - SALT - evt ha som env.
	

}
