package tdt4140.gr1801.web.server;

import java.io.IOException; 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GetURL {
	
	// Denne funksjonen legger paa de ekstra endpointene paa URL-forespoerselene.
	// Returnerer innholdet i en HTTP-respons.
	public static String getRequest(String URL) throws ClientProtocolException, IOException {
		
		HttpUriRequest request = new HttpGet("http://localhost:8080"+URL);	// Lager 
		HttpResponse response = HttpClientBuilder.create().build().execute( request );
		HttpEntity entity = response.getEntity();
	    String content = EntityUtils.toString(entity);
	    
	    return content;
		
	}
	
	
	// Denne funksjonen legger 
	
	public static String postRequest(String URL, JSONObject json) throws IOException { 

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
		    HttpPost request = new HttpPost("http://localhost:8080"+URL);
		    StringEntity params = new StringEntity(json.toString());
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    HttpResponse response = httpClient.execute(request);
		// handle response here...
			HttpEntity entity = response.getEntity();
		    String content = EntityUtils.toString(entity);
		    return content;
		} catch (Exception ex) {
		    // handle exception here
		} finally {
		    httpClient.close();
		}
		return "";
	}
	
	
}



//HELLO


