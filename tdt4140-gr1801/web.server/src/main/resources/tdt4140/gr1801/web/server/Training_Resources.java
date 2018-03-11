package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


// TODO - Faa alle utholdenhetsoektene til en client


@Path("/training")
public class Training_Resources {
	
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
	
}
