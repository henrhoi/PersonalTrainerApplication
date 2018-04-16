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

// Class with static functions for GET- and POST-requests to our server
public class GetURL {
	
	
	// This function takes in the API-URL, containing endpoints etc. 
	// Returnes the content of a GET-request
	public static String getRequest(String URL) throws ClientProtocolException, IOException {
		// Creates a GET-request on our local server with the API-URL from the input string. 
		HttpUriRequest request = new HttpGet("http://localhost:8080"+URL);
		HttpResponse response = HttpClientBuilder.create().build().execute( request );
		HttpEntity entity = response.getEntity();
	    String content = EntityUtils.toString(entity);
	    
	    //Returnes content of GET-request - which is specified in the endpoints in the Resources of the WebServer-project
	    return content;
	}
	
	
	// This function takes in the API-URL, containing endpoints etc, and a json-string that is being sent in the body of the POST-request
	// Returnes the content of a POST-request
	public static String postRequest(String URL, JSONObject json) throws IOException { 
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
		    HttpPost request = new HttpPost("http://localhost:8080"+URL);
		    StringEntity params = new StringEntity(json.toString());
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			
		    //Returnes content of POST-request - which is specified in the endpoints in the Resources of the WebServer-project
		    String content = EntityUtils.toString(entity);
		    return content;
		} catch (Exception e) { 
			e.printStackTrace();
		} finally { httpClient.close(); }
		return "";
	}	
}


