package tdt4140.gr1801.web.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
