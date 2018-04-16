package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

//This is one of our API's endpoint "/nutrition", which specifies a GET-request in order to get Nutrition-data

@Path("/nutrition")
public class Nutrition_Resources {

	
	// Specifies a possible GET-request to get all Nutrition-data about a client in JSON-format
	@GET
	@Path("/{clientID}")
	@Produces("application/json")
    public static String getAllNutrition(@PathParam("clientID") String clientID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Getting PreparedStatement from QueryFactory
		PreparedStatement stmt = QueryFactory.getAllNutritions(Integer.parseInt(clientID));
		ResultSet rs = stmt.executeQuery(); //Executing query
		String json = RSJSONConverter.ResultSetToJSON(rs).toString(); //Converting to JSON-format
		return json;

	}
	

}