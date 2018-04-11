package tdt4140.gr1801.web.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


// Denne klassen produserer PreparedStatements, som gjoer at man kan bestemme hva slags spoerringer/kommandoer som kan gjoeres opp mot databasen.
// Dersom en spoerring skal kunne gjoeres, skal den ligge her. 
public final class QueryFactory {
	
	
	// Hente SHA-256-hashet passord fra databasen
	public static PreparedStatement getPassword(String PT_ID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();		// Kobler seg til database
		PreparedStatement stmt = conn.prepareStatement("SELECT Passwrd, Salt FROM PT WHERE PT_ID = ?");  	//Gjoer klar en spoerring
		stmt.setString(1, PT_ID);	// Setter sporsmoltegn i Statementet til PT_ID. Er 1-indeksert
		return stmt;
	}

	// Hente informasjon om en PT
	public static PreparedStatement getPT(String PT_ID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();		// Kobler seg til database
		PreparedStatement stmt = conn.prepareStatement("SELECT PT_ID, Navn, Email, Birthday, Phonenr FROM PT WHERE PT_ID = ?");  	//Gjoer klar en spoerring
		stmt.setString(1, PT_ID);		// Setter sporsmoltegn i Statementet til PT_ID. Er 1-indeksert
		return stmt;
	}
	
	
	
	// Hente informasjon om en klient
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
	
	// må testes
	public static PreparedStatement getAllNutritions(Integer ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Nutrition WHERE ClientID = ?");
		stmt.setInt(1,ClientID);
		return stmt;
	}
	
	
	// må testes
	public static PreparedStatement getAllEndurance(Integer ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Endurance WHERE ClientID = ?");
		stmt.setInt(1, ClientID);
		return stmt;
	}
	
	
	// PreparedStatement for innsetting av PT i databasen
	public static PreparedStatement insertPT(String PT_ID, String Passwrd, String Salt, String Navn, String Email, String Birthday, String Phonenr) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO PT(PT_ID, Passwrd, Navn, Email, Birthday, Phonenr, Salt) VALUES (?, ?, ?, ?, ?, ?, ?)");  
		stmt.setString(1, PT_ID);
		stmt.setString(2, Passwrd);
		stmt.setString(3, Navn);
		stmt.setString(4, Email);
		stmt.setString(5, Birthday);
		stmt.setString(6, Phonenr);
		stmt.setString(7, Salt);
		return stmt;
	}
	
	// PreparedStatement for innsetting av Client i databasen
	public static PreparedStatement insertClient(String Navn, int Height, String PT_ID, int MaxPulse) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Klient(Navn, Height, PT_ID, MaxPulse)  VALUES (?, ?, ?, ?)");  
		stmt.setString(1, Navn);
		stmt.setInt(2, Height);
		stmt.setString(3, PT_ID);
		stmt.setInt(4, MaxPulse);
		return stmt;
	}
	
	
	//Kissa
	// PreparedStatement for getting information about a clients strengthTrainings
	public static PreparedStatement getStrengthTraningsFromClient(String ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Strength WHERE ClientID = ?");
		stmt.setString(1, ClientID);
		return stmt;
	}
	
	//PreparedStatement for getting information about a StrengthTrainings exercises.
	public static PreparedStatement getExercisesFromStrengthTraining(String StrengthID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Exercise WHERE StrengthID = ?");
		stmt.setString(1, StrengthID);
		return stmt;
	}
	//Kissa
	
	public static PreparedStatement getWeigthFatFromClient(String ClientID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ClientWeight WHERE ClientID = ?");
		stmt.setInt(1, Integer.parseInt(ClientID));
		return stmt;
	}
	

	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PreparedStatement stmt = QueryFactory.insertClient("Vilde Arntzen", 170, "henrhoi",200);
		stmt.execute();
	}
	
	
	
	
	
	
	
	
	
	
}
