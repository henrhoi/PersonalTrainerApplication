package tdt4140.gr1801.web.server;

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;


// TODO - Faa alle styrkeoektene - samt oevelser(?) til en client

// TODO - Faa alle utholdenhetsoektene til en client


@Path("/training")
public class Training_Resources {
	
	// ikke testet 
	@GET
	@Path("/endurance/{clientid}")
	@Produces("application/json")
	public String getAlleEndurance(@PathParam("clientid") String clientid) throws JSONException, SQLException, NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		PreparedStatement stmt = QueryFactory.getAllEndurance(Integer.parseInt(clientid));
		ResultSet rs = stmt.executeQuery();
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;
	}
		
	@GET
	@Path("/strength/{ClientID}") 
	@Produces("application/json")
	public String getStrengthTranings(@PathParam("ClientID") String ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println("Getting StrengthTranings for Client with ID: " + ClientID);
		PreparedStatement stmt  = QueryFactory.getStrengthTraningsFromClient(ClientID);
		ResultSet rs = stmt.executeQuery();
		String json  = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;
	}
	
	@GET
	@Path("/exercise/{StrengthID}") 
	@Produces("application/json")
	public String getExercises(@PathParam("StrengthID") String StrengthID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println("Getting Exercises for Strength with ID: " + StrengthID);
		PreparedStatement stmt  = QueryFactory.getExercisesFromStrengthTraining(StrengthID);
		ResultSet rs = stmt.executeQuery();
		String json  = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String trainingInfo = GetURL.getRequest("/exercise/1");
		System.out.println(trainingInfo);
		
		
	}
	
}
