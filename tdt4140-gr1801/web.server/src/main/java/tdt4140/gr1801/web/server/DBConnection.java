package tdt4140.gr1801.web.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
	
	
	// Statisk funksjon som kan brukes for aa koble seg opp mot databasen. 
	// Passord og brukernavn ligger i koden, mulig det skal gaa inn som startargs eller env. variabler
	public static Connection getDBConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/PersonalTrainerDB";
		String SSL = "?useSSL=false";
		String user = "root";
		String pass = "MyNewPass";
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		Connection conn = DriverManager.getConnection (url+SSL, user, pass);
		
		return conn;
	}

}
