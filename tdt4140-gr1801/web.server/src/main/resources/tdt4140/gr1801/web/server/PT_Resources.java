package tdt4140.gr1801.web.server;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;


//This is one of our API's endpoint "/pt", which specifies some GET and POST-requests

@Path("/pt")
public class PT_Resources {

	// GET-function for getting all information about a PT, discarding login-information
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String getPT(@PathParam("param") String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		// Getting PreparedStatement from QueryFactory
    		PreparedStatement stmt = QueryFactory.getPT(username);
		ResultSet rs = stmt.executeQuery();	// Executing query
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();	// Converting result to JSON-format
		return json;
    }
    
    
    // Defines POST-request for the changing password of a specific PT
    @POST
    @Path("/changepassword")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changePassword(String data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		JSONObject json = new JSONObject(data);
	    String PT_ID = json.getString("PT_ID");
	    String Passwrd = json.getString("Passwrd");
	    String Salt = json.getString("Salt");
	
		// Getting PreparedStatement from QueryFactory
	    PreparedStatement stmt = QueryFactory.changePassword(PT_ID, Passwrd, Salt);
	    stmt.execute();
	    
	  //If everything went ok a "201 CREATED" response will be sent with a corresponding message
	    return Response.status(201).entity("Password for "+ PT_ID +" is changed in the database, if all input were correct").build(); 
	}

}