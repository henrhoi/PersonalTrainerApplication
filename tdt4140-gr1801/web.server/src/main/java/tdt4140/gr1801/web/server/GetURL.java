package tdt4140.gr1801.web.server;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

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
	
	public static String postRequest(String URL, NameValuePair[] data) throws IOException {
		PostMethod post = new PostMethod(URL);
		post.setRequestBody(data);
		// execute method and handle any error responses.

		InputStream in = post.getResponseBodyAsStream();
		
		
		return URL;
		
		// handle response.
		
		// Do something with http.getInputStream()
	}
	
	
}



