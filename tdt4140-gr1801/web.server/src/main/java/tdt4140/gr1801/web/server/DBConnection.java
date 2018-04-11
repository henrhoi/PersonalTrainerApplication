package tdt4140.gr1801.web.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public final class DBConnection {
	
	
	// Statisk funksjon som kan brukes for aa koble seg opp mot databasen. 
	// Passord og brukernavn ligger i koden, mulig det skal gaa inn som startargs eller env. variabler
	public static Connection getDBConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://mysql.stud.ntnu.no/henrhoi_PersonalTrainerDB?autoReconnect=true&useSSL=false";
		String user = "henrhoi_PersonalTrainerDB";
		String pass = "MyNewPass";
		
		Properties p = new Properties();
		p.put("user", user);
		p.put("password", pass);
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url, p);
		
		return conn;
	}


}
