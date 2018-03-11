package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/nutrition")
public class Nutrition_Resources {

// TODO - Faa all naeringsdata til en klient
// EVT TODO - Faa naeringsdata til en klient paa dato
	
	@GET
	@Path("/{clientID}")
	@Produces("application/json")
    public String getAllNutrition(@PathParam("clientID") String clientID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Returner all registrert data over mat til en klient
		PreparedStatement stmt = QueryFactory.getAllNutritions(Integer.parseInt(clientID));
		ResultSet rs = stmt.executeQuery();
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;

	}
	

}