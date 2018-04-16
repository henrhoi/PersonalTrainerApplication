package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONException;

//This is one of our API's endpoint "/training", which specifies some GET-requests for endurance- and training-data

@Path("/training")
public class Training_Resources {
	
	
	// GET-request for getting all Endurance-data about a specific client
	@GET
	@Path("/endurance/{clientid}")
	@Produces("application/json")
	public String getAlleEndurance(@PathParam("clientid") String clientid) throws JSONException, SQLException, NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// Getting PreparedStatement from QueryFactory
		PreparedStatement stmt = QueryFactory.getAllEndurance(Integer.parseInt(clientid));
		ResultSet rs = stmt.executeQuery();
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;
	}
	

	// GET-request for getting all Strength-data about a specific client
	@GET
	@Path("/strength/{ClientID}") 
	@Produces("application/json")
	public String getStrengthTranings(@PathParam("ClientID") String ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Getting PreparedStatement from QueryFactory
		PreparedStatement stmt  = QueryFactory.getStrengthTraningsFromClient(ClientID);
		ResultSet rs = stmt.executeQuery();
		String json  = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;
	}
	
	
	// GET-request for getting all Exercise-data about a specific Strength-object
	@GET
	@Path("/exercise/{StrengthID}") 
	@Produces("application/json")
	public String getExercises(@PathParam("StrengthID") String StrengthID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Getting PreparedStatement from QueryFactory
		PreparedStatement stmt  = QueryFactory.getExercisesFromStrengthTraining(StrengthID);
		ResultSet rs = stmt.executeQuery();
		String json  = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;
	}
	
}
