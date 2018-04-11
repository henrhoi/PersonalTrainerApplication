package tdt4140.gr1801.web.server;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

@Path("/weeklyprogram")
public class Program_Resources {
	
	
	@GET
    @Path("/{clientID}")
    @Produces("application/json")
    public static String getWeeklyProgram(@PathParam("clientID") String clientID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PreparedStatement stmt = QueryFactory.getProgramFromClient(clientID);
		ResultSet rs = stmt.executeQuery();
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;

	}
	
//	 @POST
//    //@Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void createWeeklyProgram() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//    	JSONObject json = new JSONObject(data);
//        String Navn = json.getString("Navn");
//        int Height = json.getInt("Height");
//        String PT_ID = json.getString("PT_ID");
//
//        PreparedStatement stmt = QueryFactory.insertClient(Navn, Height, PT_ID);
//        stmt.execute();
//
//    }
	  
	  
	  
//	  public static void main(String[] args) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ClientProtocolException, IOException {
//  		//Skjekker at jeg faar riktig info om program til klient med clientID = 1
//  	
//  		String programInfo = GetURL.getRequest("/weeklyprogram/1");
//  		System.out.println(programInfo);
//  		
//  		String j = Program_Resources.getWeeklyProgram(Integer.toString(1));
//  		System.out.println(j);
//  }

}
