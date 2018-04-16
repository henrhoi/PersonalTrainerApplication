package tdt4140.gr1801.web.server;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;




@Path("/weeklyprogram")
public class Program_Resources {
	
	
	
	@GET
    @Path("/{clientID}")
    @Produces("application/json")
    public static String getWeeklyProgram(@PathParam("clientID") String clientID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println(clientID);
		PreparedStatement stmt = QueryFactory.getProgramFromClient(clientID);
		ResultSet rs = stmt.executeQuery();
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;

	}
	
	@POST
	@Path("/client")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void createWeeklyProgram(String data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    	JSONObject json = new JSONObject(data);
    	PreparedStatement stmt;
    	int clientID = json.getInt("ClientID");
    	String day = json.getString("Day");
    	if (json.length() == 3 ) {
    		String exercises = json.getString("Exercises");
    		stmt = QueryFactory.insertWeeklyProgram(clientID, day, 0, 0.0, 0.0, "", exercises);
            
    	}
    	else {
    		int duration = json.getInt("Duration");
            double distance = json.getDouble("Distance");
            double speed = json.getDouble("Speed");
            String description = json.getString("Description");
            stmt = QueryFactory.insertWeeklyProgram(clientID, day, duration,
            		distance, speed, description, "");
    		
    		
    	}
       
        stmt.execute();

    }
	  
	  
	  
	  public static void main(String[] args) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ClientProtocolException, IOException {
  		//Skjekker at jeg faar riktig info om program til klient med clientID = 1
  	
  		String programInfo = GetURL.getRequest("/weeklyprogram/1");
  		System.out.println(programInfo);
//  		
//  		String j = Program_Resources.getWeeklyProgram("1");
//  		System.out.println(j);
//  		createWeeklyProgram("Monday", 120, 12.0, 6.5, "Intervaller 4x4", null, null, null, null);
  
  		
  		
	  
	  }

}
