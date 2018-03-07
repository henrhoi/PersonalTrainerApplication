package tdt4140.gr1801.web.server;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

@Path("/pt")
public class PT_Resources {

	// Get-funksjon for aa faa informasjonen om en PT
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String getPT(@PathParam("param") String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		PreparedStatement stmt = QueryFactory.getPT(username);	// Henter et statement fra QueryFactoryen
		ResultSet rs = stmt.executeQuery();	// Utfoerer spoerringen
		String json = RSJSONConverter.ResultSetToJSON(rs).toString();	// Konverterer resultat til JSON

		return json;
    }
	
    

    
 
   
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ClientProtocolException, IOException {
    		//finner info om pt med pt_id = "henrhoi"
    		String pt_info = GetURL.getContent("/pt/henrhoi");
    		System.out.println(pt_info);

	}


}

// JSON respons