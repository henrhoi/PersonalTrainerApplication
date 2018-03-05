package tdt4140.gr1801.web.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// Denne klassen produserer PreparedStatements, som gjoer at man kan bestemme hva slags spoerringer/kommandoer som kan gjoeres opp mot databasen.
// Dersom en spoerring skal kunne gjoeres, skal den ligge her. 
public final class QueryFactory {
	
	
	// Hente SHA-256-hashet passord fra databasen
	public static PreparedStatement getPassword(String PT_ID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();		// Kobler seg til database
		PreparedStatement stmt = conn.prepareStatement("SELECT Passwrd FROM PT WHERE PT_ID = ?");  	//Gjoer klar en spoerring
		stmt.setString(1, PT_ID);	// Setter ? i Statementet til PT_ID. Er 1-indeksert
		return stmt;
	}

	// Hente informasjon om én PT
	public static PreparedStatement getPT(String PT_ID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();		// Kobler seg til database
		PreparedStatement stmt = conn.prepareStatement("SELECT PT_ID, Navn, Email, Birthday, Phonenr FROM PT WHERE PT_ID = ?");  	//Gjoer klar en spoerring
		stmt.setString(1, PT_ID);		// Setter ? i Statementet til PT_ID. Er 1-indeksert
		return stmt;
	}
	
	
	
	// Hente informasjon om én klient
	public static PreparedStatement getClient(Integer ClientID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Klient WHERE ClientID = ?");  
		stmt.setInt(1, ClientID);
		return stmt;
	}
	
	
	// Prepared Statement for aa hente informasjonen om alle klientene til en PT
	public static PreparedStatement getAllClients(String PT_ID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Klient WHERE PT_ID = ?");  
		stmt.setString(1, PT_ID);
		return stmt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
