package tdt4140.gr1801.web.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;

public class Maintester {
	
	
	// Min tester for aa kunne proeve ut nye ting
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Connection conn = DBConnection.getDBConnection();

		
		PreparedStatement stmt = conn.prepareStatement("SELECT Passwrd FROM PT WHERE PT_ID = ?");  
		
		stmt.setString(1, "henrhoi");
		ResultSet rs = stmt.executeQuery();
		
		JSONArray json = RSJSONConverter.ResultSetToJSON(rs);
		
		System.out.println(json);
		
		
		
		/*
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PT");
		*/
		/*
		while (rs.next()) {
			System.out.println(rs.getString("Passwrd"));			
		}
		*/
		
		
/*		PreparedStatement stmt = QueryFactory.getPassword("henrhoi");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("Passwrd"));
		}*/
		
	
		
	}

}
