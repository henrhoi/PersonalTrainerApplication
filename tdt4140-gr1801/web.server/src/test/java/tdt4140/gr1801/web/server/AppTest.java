package tdt4140.gr1801.web.server;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;

public class AppTest extends TestCase{
	Thread thread;
	
	@Before
	protected void setUp() throws InterruptedException, IllegalStateException {
	    	thread = new Thread () {
				public void run () {
					// Creating server on port 8080
					WebServer webserver = new WebServer(8080);
					try {
						try {
							webserver.setup();} catch (Exception e) {e.printStackTrace();}
						System.out.println("Setting up server");
						try {webserver.server.start();} catch (Exception e) {e.printStackTrace();}
						System.out.println("Server started");
						try {webserver.server.join();} catch (InterruptedException e) {e.printStackTrace();}	
					} finally {
						try {
							webserver.stopServer();
							System.out.println("Server stopped");							
						} catch(IllegalStateException e){
							System.out.println("Thread stopped");
							
						}
					}}};
			thread.start();
			Thread.sleep(2000);
	}
	
	public void testClientResources() throws ClientProtocolException, IOException{
		String content = GetURL.getRequest("/login/henrhoi");
		String expected = "{\"Salt\":\"gR+0AXGTRkaGNBktmOoNIaGhddA=\",\"Passwrd\":\"8fd8f77d2bb5ea82471cc18fe80a749311b0819a0938dac935725a84b4c562c3\"}";
		assertEquals(content, expected);
		
	}
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		thread.stop();
	}
	
	

}
