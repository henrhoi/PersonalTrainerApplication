package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/signup")
public class Signup_Resources {
	
	
	//Svarer paa HTTP-POST requests, og legger til en PT i database. Forslag til bruk ligger i _main_ i PersonalTrainer.java
    @POST
    @Path("/pt")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPT(String data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    		JSONObject json = new JSONObject(data);
        String PT_ID = json.getString("PT_ID");
        System.out.println(PT_ID);
        String Passwrd = json.getString("Passwrd");
        String Navn = json.getString("Navn");
        String Email = json.getString("Email");
        String Birthday = json.getString("Birthday");
        String Phonenr = json.getString("Phonenr");
        
        PreparedStatement stmt = QueryFactory.insertPT(PT_ID, Passwrd, Navn, Email, Birthday, Phonenr);
        stmt.execute();
        
        return Response.status(201).entity(Navn + " added to PT-table in database if all input were correct").build(); 
    }
    
    
    
    
    // Denne må lages i issuen om opprettelse av Klient i database
    @POST
    @Path("/client")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClient(String data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        return Response.status(201).entity("Navn" + " added to Klient-table in database if all input were correct").build(); 
    }
    


}


