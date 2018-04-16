package tdt4140.gr1801.web.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// maa testes
	public static PreparedStatement getAllNutritions(Integer ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Nutrition WHERE ClientID = ?");
		stmt.setInt(1,ClientID);
		return stmt;
	}
	
	
	// maa testes
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
	
	// PreparedStatement for innsetting av WeeklyProgram i databasen
		public static PreparedStatement insertWeeklyProgram(int clientID, String day, int duration, double distance, 
				double speed, String description, String exercises) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			Connection conn = DBConnection.getDBConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO WeeklyProgram VALUES (?, ?, ?, ?, ?, ?, ?)"
					+ " ON DUPLICATE KEY UPDATE");  
			stmt.setInt(1, clientID);
			stmt.setString(2, day);
			stmt.setInt(3, duration);
			stmt.setDouble(4, distance);
			stmt.setDouble(5, speed);
			stmt.setString(6, description);
			stmt.setString(7, exercises);
			return stmt;
		}
		
	
	// PreparedStatement for getting information about a clients weekly program
	public static PreparedStatement getProgramFromClient(String ClientID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM WeeklyProgram WHERE ClientID = ?");  
		stmt.setString(1, ClientID);
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
	
	public static PreparedStatement changePassword(String PT_ID, String passwrd, String salt) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("UPDATE PT SET Passwrd = ?, Salt = ? WHERE PT_ID = ?");
		stmt.setString(1, passwrd);
		stmt.setString(2, salt);
		stmt.setString(3, PT_ID);
		return stmt;
	}
	
	// Metoden lages for å sjekke om en client tilhører PT i metoden deleteClient i clientResources
	public static PreparedStatement getPTforClient(int ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT PT_ID FROM Klient WHERE ClientID = ?");
		stmt.setInt(1, ClientID);;
		return stmt;
	}
	
	public static PreparedStatement getClientProgressionPictures(String clientID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ProgressionPicture WHERE ClientID = ?");
		stmt.setInt(1, Integer.parseInt(clientID));
		return stmt;
		
	}
	
	// metode for å slette data for klient i databasen
	public static List<PreparedStatement> deleteAllClientData(int ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM Nutrition WHERE ClientID = ?");
		PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Endurance WHERE ClientID = ?");
		PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM Exercise WHERE StrengthID IN (SELECT StrengthID FROM Strength WHERE ClientID = ?)");
		PreparedStatement stmt4 = conn.prepareStatement("DELETE FROM Strength WHERE ClientID = ?");
		PreparedStatement stmt5 = conn.prepareStatement("DELETE FROM ProgressionPicture WHERE ClientID = ?");
		PreparedStatement stmt6 = conn.prepareStatement("DELETE FROM WeeklyProgram WHERE ClientID = ?");
		PreparedStatement stmt7 = conn.prepareStatement("DELETE FROM ClientWeight WHERE ClientID = ?");
		PreparedStatement stmt8 = conn.prepareStatement("DELETE FROM Klient WHERE ClientID = ?");
		stmt1.setInt(1, ClientID);
		stmt2.setInt(1, ClientID);
		stmt3.setInt(1, ClientID);
		stmt4.setInt(1, ClientID);
		stmt5.setInt(1, ClientID);
		stmt6.setInt(1, ClientID);
		stmt7.setInt(1, ClientID);
		stmt8.setInt(1, ClientID);
		List<PreparedStatement> statements = new ArrayList<PreparedStatement>();
		statements.add(stmt1);
		statements.add(stmt2);
		statements.add(stmt3);
		statements.add(stmt4);
		statements.add(stmt5);
		statements.add(stmt6);
		statements.add(stmt7);
		statements.add(stmt8);
		return statements;
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		PreparedStatement stmt = QueryFactory.insertClient("Vilde Arntzen", 170, "henrhoi");
//		stmt.execute();
		
//		PreparedStatement stmt = QueryFactory.getProgramFromClient("1");
//		ResultSet rs = stmt.executeQuery();
//		while(rs.next()) {
//			System.out.println(rs.getString("day"));
//		}
//		System.out.println("I en main");
//		
//		PreparedStatement st = insertWeeklyProgram("1", "Monday", 120, 12.0, 6.5, "Intervaller 4x4", "", 0.0, 0, "");
//		st.execute();
	}

}
