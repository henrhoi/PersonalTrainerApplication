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


@Path("/client")
public class Client_Resources {
	
	// hente informasjon om en klient med klient ID = ?
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String getClient(@PathParam("param") String clientID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    		PreparedStatement stmt = QueryFactory.getClient(Integer.parseInt(clientID));
    		ResultSet rs = stmt.executeQuery();
    		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
    		return json;

	}
    
    
    
    //Kan hentes paa /all/PT_ID
    @GET
    @Path("/all/{pt}")
    @Produces("application/json")
    public static String getClients(@PathParam("pt") String PT_ID) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    			PreparedStatement stmt = QueryFactory.getAllClients(PT_ID);
        		ResultSet rs = stmt.executeQuery();
        		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
        		return json;
	}
    
    
    
    @GET
    @Path("/weightfat/{clientid}")
    @Produces("application/json")
    public String getWeigthFatFromClient(@PathParam("clientid") String ClientID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    		PreparedStatement stmt = QueryFactory.getWeigthFatFromClient(ClientID);
    		ResultSet rs = stmt.executeQuery();
    		String json = RSJSONConverter.ResultSetToJSON(rs).toString();
    		return json;
    	
    }
    
    
    
    
    
    public static void main(String[] args) throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ClientProtocolException, IOException {
    		//Skjekker at jeg faar riktig info om client med clientID = 1
    	
    		String clientInfo = GetURL.getRequest("/client/1");
    		System.out.println(clientInfo);
    		
    		Client_Resources.getClients("henrhoi");
    		
    		String allClients = GetURL.getRequest("/all/henrhoi");
    		System.out.println(allClients);

    }
}
