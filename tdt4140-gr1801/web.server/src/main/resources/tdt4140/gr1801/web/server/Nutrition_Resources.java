package tdt4140.gr1801.web.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/nutrition")
public class Nutrition_Resources {

// TODO - Faa all naeringsdata til en klient
// EVT TODO - Faa naeringsdata til en klient paa dato
	
	@GET
	@Path("/{clientID}")
    @Produces("application/json")
    public String getAllNutrition(@PathParam("clientID") String clientID) {
		// Returner all registrert data over mat til en klient
		
		return "";

	}
	
	@GET
	@Path("/date/{date}/{clientID}")
    @Produces("application/json")
    public String getNutritionByDate(@PathParam("date") String date, @PathParam("clientID") String clientID) {
		// Returner data om mat for en dag for en klient
		
		return "";

	}

}
// JSON respons