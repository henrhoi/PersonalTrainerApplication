package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;


//This is one of our API's endpoint "/signup", which specifies some POST-requests for new PTs and clients

@Path("/signup")
public class Signup_Resources {
	

	// This answers to HTTP-POST-request on this URL, and adds a PT to the database if JSON in body contains valid information
    @POST
    @Path("/pt")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPT(String data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    		JSONObject json = new JSONObject(data);
        String PT_ID = json.getString("PT_ID");
        System.out.println(PT_ID);
        String Passwrd = json.getString("Passwrd");
        String Salt = json.getString("Salt");
        String Navn = json.getString("Navn");
        String Email = json.getString("Email");
        String Birthday = json.getString("Birthday");
        String Phonenr = json.getString("Phonenr");

		// Getting PreparedStatement from QueryFactory
        PreparedStatement stmt = QueryFactory.insertPT(PT_ID, Passwrd, Salt, Navn, Email, Birthday, Phonenr);
        stmt.execute();
        
      //If everything went ok a "201 CREATED" response will be sent with a corresponding message
        return Response.status(201).entity(Navn + " added to PT-table in database if all input were correct").build(); 
    }
    
    
    
    
	// This answers to HTTP-POST-request on this URL, and inserts a new Client to the database, if JSON in the request's body contains valid information
    @POST
    @Path("/client")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClient(String data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    		JSONObject json = new JSONObject(data);
        String Navn = json.getString("Navn");
        int Height = json.getInt("Height");
        String PT_ID = json.getString("PT_ID");
        int MaxPulse = json.getInt("MaxPulse");

		// Getting PreparedStatement from QueryFactory
        PreparedStatement stmt = QueryFactory.insertClient(Navn, Height, PT_ID, MaxPulse);
        stmt.execute();
        
      //If everything went ok a "201 CREATED" response will be sent with a corresponding message
        return Response.status(201).entity(Navn + " added to Klient-table in database if all input were correct").build(); 
    }
    

}
