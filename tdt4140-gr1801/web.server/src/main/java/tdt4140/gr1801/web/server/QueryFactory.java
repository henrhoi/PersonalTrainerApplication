package tdt4140.gr1801.web.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// This class containes static methods that produces PreparedStatements, and makes up all the queries our program is allowed to do.
// We decided to use PreparedStatements because our queries is going to be rewritten and compiled by the database server
// We also wanted protection against SQL-injections

// If a query should be called, it shall lie here
public final class QueryFactory {
	
	
	// Getting password and salt from database with PT_ID as input
	public static PreparedStatement getPassword(String PT_ID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();		// Getting conection to database
		// Preparing a statement. Using ? for unspecified fields
		PreparedStatement stmt = conn.prepareStatement("SELECT Passwrd, Salt FROM PT WHERE PT_ID = ?");  	//Preparing a statement
		stmt.setString(1, PT_ID);	// Specifying every ? in the statement.
		return stmt; // Returning statement
	}
	

	// Retreiving all information about an PersonalTrainer from the database, not considering login information
	public static PreparedStatement getPT(String PT_ID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection();		// Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT PT_ID, Navn, Email, Birthday, Phonenr FROM PT WHERE PT_ID = ?");  
		stmt.setString(1, PT_ID);
		return stmt;
	}
	

	// Retreiving information about Client
	public static PreparedStatement getClient(Integer ClientID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Klient WHERE ClientID = ?");  
		stmt.setInt(1, ClientID);
		return stmt;
	}
	
	
	// PreparedStatement for retreiving all informaton about all clients to one PT
	public static PreparedStatement getAllClients(String PT_ID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Klient WHERE PT_ID = ?");  
		stmt.setString(1, PT_ID);
		return stmt;
	}
	
	
	// PreparedStatement for getting all Nutrition-data on ClientID
	public static PreparedStatement getAllNutritions(Integer ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Nutrition WHERE ClientID = ?");
		stmt.setInt(1,ClientID);
		return stmt;
	}
	
	
	// PreparedStatement for getting all Endurance-data on ClientID
	public static PreparedStatement getAllEndurance(Integer ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Endurance WHERE ClientID = ?");
		stmt.setInt(1, ClientID);
		return stmt;
	}
	
	
	// PreparedStatement for inserting a new PT in the database
	public static PreparedStatement insertPT(String PT_ID, String Passwrd, String Salt, String Navn, String Email, String Birthday, String Phonenr) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
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
	
	
	// PreparedStatement for inserting a new Client in the database
	public static PreparedStatement insertClient(String Navn, int Height, String PT_ID, int MaxPulse) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Klient(Navn, Height, PT_ID, MaxPulse)  VALUES (?, ?, ?, ?)");  
		stmt.setString(1, Navn);
		stmt.setInt(2, Height);
		stmt.setString(3, PT_ID);
		stmt.setInt(4, MaxPulse);
		return stmt;
	}
		
		
	// PreparedStatement for getting information about a client's weekly program
	public static PreparedStatement getProgramFromClient(String ClientID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM WeeklyProgram WHERE ClientID = ?");  
		stmt.setString(1, ClientID);
		return stmt;
	}
	
	
	// PreparedStatement for getting information about a client's strengthtrainings
	public static PreparedStatement getStrengthTraningsFromClient(String ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Strength WHERE ClientID = ?");
		stmt.setString(1, ClientID);
		return stmt;
	}
	
	
	//PreparedStatement for getting information about a strengthtraining's exercises.
	public static PreparedStatement getExercisesFromStrengthTraining(String StrengthID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Exercise WHERE StrengthID = ?");
		stmt.setString(1, StrengthID);
		return stmt;
	}
	
	
	// PreparedStatement for getting all weigth and fat data about a client
	public static PreparedStatement getWeigthFatFromClient(String ClientID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ClientWeight WHERE ClientID = ?");
		stmt.setInt(1, Integer.parseInt(ClientID));
		return stmt;
	}
	
	
	// PreparedStatement for changing the password-field of an PT in the database
	public static PreparedStatement changePassword(String PT_ID, String passwrd, String salt) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("UPDATE PT SET Passwrd = ?, Salt = ? WHERE PT_ID = ?");
		stmt.setString(1, passwrd);
		stmt.setString(2, salt);
		stmt.setString(3, PT_ID);
		return stmt;
	}
	

	// PreparedStatement for getting the PT of an Client, used in the method deleteClient() in Client_Resources.java, for checking whether or not a client belongs to a certain PT
	public static PreparedStatement getPTforClient(int ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT PT_ID FROM Klient WHERE ClientID = ?");
		stmt.setInt(1, ClientID);;
		return stmt;
	}
	
	
	// PreparedStateent used to get all ProgressionPictures to a client
	public static PreparedStatement getClientProgressionPictures(String clientID) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ProgressionPicture WHERE ClientID = ?");
		stmt.setInt(1, Integer.parseInt(clientID));
		return stmt;
	}
	
	
	// Method for deleting all data about a Client
	public static List<PreparedStatement> deleteAllClientData(int ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection(); // Getting conection to database
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
	
}
