package tdt4140.gr1801.web.server;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;


@Path("/client")
public class Client_Resources {
	
	// hente informasjon om en klient med klient ID = ?
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String getClient(@PathParam("param") String clientID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    		PreparedStatement stmt = QueryFactory.getClient(Integer.parseInt(clientID));
    		ResultSet rs = stmt.executeQuery();
    		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
    		return json;

	}
    
    
    
    //Kan hentes paa /all/PT_ID
    @GET
    @Path("/all/{pt}")
    @Produces("application/json")
    public static String getClients(@PathParam("pt") String PT_ID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    			PreparedStatement stmt = QueryFactory.getAllClients(PT_ID);
        		ResultSet rs = stmt.executeQuery();
        		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
        		return json;
	}
    
    
    
    @GET
    @Path("/weightfat/{clientid}")
    @Produces("application/json")
    public String getWeigthFatFromClient(@PathParam("clientid") String ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    		PreparedStatement stmt = QueryFactory.getWeigthFatFromClient(ClientID);
    		ResultSet rs = stmt.executeQuery();
    		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
    		return json;
    	
    }
    
    

    
    @POST
    @Path("/remove")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response deleteClient(String data) throws NoSuchAlgorithmException, ClientProtocolException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		JSONObject json = new JSONObject(data);
		String username = json.getString("PT_ID");
		String password = json.getString("Passwrd");
		int clientID = json.getInt("ClientID");
		PreparedStatement stmt = QueryFactory.getPTforClient(clientID);
		ResultSet res = stmt.executeQuery();
		String pt_id = null;
		while (res.next()) {
			pt_id = res.getString("PT_ID");
		}
		
		// Authenticating the PT that is trying to delete that specific client.
		// "Is the PT the personal trainer to client with this specific ClientID"
		 if (username.equals(pt_id)) {
			 //Checking if the input password is corresponding with the password in database
			if(LoginModule.checkLogin(username, password)) {
				// Retrieving all statements necessary for deleting all current informaiton about an Client.
				List<PreparedStatement> statements = QueryFactory.deleteAllClientData(clientID);
				List<String> beingDeleted = Arrays.asList("Nutrition", "Endurance","Exercise", "Strength", "ProgressionPictures", "WeeklyProgram", "ClientWeight", "Client");
				for (int i=0; i<statements.size();i++) {
					// Executing all PreparedStatements
					statements.get(i).execute();
					System.out.println("Deleting " + beingDeleted.get(i));
				}
				return Response.status(201).entity(username + " with data was deleted in database if all input were correct").build(); 
    		} else {
    			return Response.status(201).entity("Wrong username or password. Please try again.").build(); 
			}
		} else {
			return Response.status(201).entity("This client does not belong to "+username).build(); 
		}
    }
    
    public static void main(String[] args) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ClientProtocolException, IOException, NoSuchAlgorithmException {
    		//Skjekker at jeg faar riktig info om client med clientID = 1
    		// Henrik har testet dette, funker
		JSONObject json = new JSONObject();
		json.put("PT_ID", "axeloh");
		json.put("Passwrd", "axelerkul321");
		json.put("ClientID", 11);
		
		System.out.println(Client_Resources.deleteClient(json.toString()));
    }
    

}
