package tdt4140.gr1801.web.server;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

//This is one of our API's endpoint "/weeklyprogram", which specifies a GET-request in order to get Program-data

@Path("/weeklyprogram")
public class Program_Resources {
	
	
	//Specifies a possible GET-request for getting the weeklyprogram of a specific client in JSON-format

	@GET
    @Path("/{clientID}")
    @Produces("application/json")
    public static String getWeeklyProgram(@PathParam("clientID") String clientID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Getting PreparedStatement from QueryFactory
		PreparedStatement stmt = QueryFactory.getProgramFromClient(clientID);
		ResultSet rs = stmt.executeQuery();
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
		return json;

	}

}
