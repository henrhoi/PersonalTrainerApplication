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

@Path("/login")
public class Login_Resource {
	
	// Get for /login/username for aa hente SHA-passord i database
	@GET
    @Path("/{param}")
    public Response getPassword(@PathParam("param") String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PreparedStatement stmt = QueryFactory.getPassword(username);
		ResultSet rs = stmt.executeQuery();
		JSONArray jsonarray = RSJSONConverter.ResultSetToJSON(rs);
		
		
		if (jsonarray.toString().equals("[]")) {
			return Response.status(200).entity(jsonarray.toString()).build();
		} 
		JSONObject json = jsonarray.getJSONObject(0);
		System.out.println(json);
		
		return Response.status(200).entity(json.toString()).build();
	}
	
}
