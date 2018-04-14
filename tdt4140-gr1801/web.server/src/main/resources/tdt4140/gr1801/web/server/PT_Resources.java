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

@Path("/pt")
public class PT_Resources {

	// Get-funksjon for aa faa informasjonen om en PT
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String getPT(@PathParam("param") String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		PreparedStatement stmt = QueryFactory.getPT(username);	// Henter et statement fra QueryFactoryen
		ResultSet rs = stmt.executeQuery();	// Utfoerer spoerringen
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();	// Konverterer resultat til JSON
		return json;
    }
    
    
    @POST
    @Path("/changepassword")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changePassword(String data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		JSONObject json = new JSONObject(data);
	    String PT_ID = json.getString("PT_ID");
	    String Passwrd = json.getString("Passwrd");
	    String Salt = json.getString("Salt");
	
	    PreparedStatement stmt = QueryFactory.changePassword(PT_ID, Passwrd, Salt);
	    stmt.execute();
	    return Response.status(201).entity("Password for "+ PT_ID +" is changed in the database, if all input were correct").build(); 
	}
    
	
 
   
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ClientProtocolException, IOException {
    		//finner info om pt med pt_id = "henrhoi"
    		String pt_info = GetURL.getRequest("/pt/henrhoi");
    		System.out.println(pt_info);

	}


}

// JSON respons