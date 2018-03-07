package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/login")
public class Login_Resource {
	
	// Get for /login/username for aa hente SHA-passord i database
	@GET
    @Path("/{param}")
    public Response getPassword(@PathParam("param") String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String hashedpasswrd = "";
		PreparedStatement stmt = QueryFactory.getPassword(username);
		ResultSet rs = stmt.executeQuery();
		
		// Henter foerste, og i dette tilfelle, eneste paramenter i rs
		while (rs.next()){
			hashedpasswrd = rs.getString("Passwrd"); 
		}
		
		return Response.status(200).entity(hashedpasswrd).build();
	}

}
