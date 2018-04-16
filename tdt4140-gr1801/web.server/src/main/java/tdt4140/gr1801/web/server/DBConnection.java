package tdt4140.gr1801.web.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

// This class is handling all matters regarding connection with our database at NTNU-servers
public final class DBConnection {
	//Static Connection-object which gets returned from the getDBConnection()-method
	static Connection conn = null;
	
	// Static function that is used to connect to the database.
	public static Connection getDBConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// If the static Connection is null, we create a new Connection, if not we return the Connection above. 
		if (conn == null) {
			// Password and username is in the code, could be changed to startargs or enviromental variabels when handling sensitive data or untrusted users
			String url = "jdbc:mysql://mysql.stud.ntnu.no/henrhoi_PersonalTrainerDB?autoReconnect=true&useSSL=false";
			String user = "henrhoi_PersonalTrainerDB";
			String pass = "MyNewPass";
			
			Properties p = new Properties();
			p.put("user", user);
			p.put("password", pass);
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, p);
		}
		return conn;
	}


}
