package tdt4140.gr1801.web.server;

import java.io.IOException;

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
	public static String getContent(String URL) throws ClientProtocolException, IOException {
		
		HttpUriRequest request = new HttpGet("http://localhost:8080"+URL);	// Lager 
		HttpResponse response = HttpClientBuilder.create().build().execute( request );
		HttpEntity entity = response.getEntity();
	    String content = EntityUtils.toString(entity);
	    
	    return content;
		
	}


}
