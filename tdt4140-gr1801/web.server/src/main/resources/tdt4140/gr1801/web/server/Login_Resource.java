package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

//This is one of our API's endpoint "/login", which specifies a GET-request in order to login

@Path("/login")
public class Login_Resource {
	
	// GET-method for retreiving the salt and hashed password of a PT based on PT_ID
	@GET
    @Path("/{param}")
    public Response getPassword(@PathParam("param") String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Getting PreparedStatement from QueryFactory
		PreparedStatement stmt = QueryFactory.getPassword(username);
		ResultSet rs = stmt.executeQuery();
		JSONArray jsonarray = RSJSONConverter.ResultSetToJSON(rs);
		
		// Checking if the JSON-file is empty.
		if (jsonarray.toString().equals("[]")) {
			return Response.status(200).entity(jsonarray.toString()).build();
		} 
		JSONObject json = jsonarray.getJSONObject(0);
		
		//If everything went ok a 200 OK response will be sent with the JSON-file
		return Response.status(200).entity(json.toString()).build();
	}
	
}
