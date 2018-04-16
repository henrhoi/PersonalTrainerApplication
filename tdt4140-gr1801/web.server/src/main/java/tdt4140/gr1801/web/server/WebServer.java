package tdt4140.gr1801.web.server;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/*
Procedure for starting server:
	WebServer server = new WebServer(8080);
	server.start();
	server.join();
*/



// Dette er WebServeren som kommer til aa bli brukt i prosjektet. Det er en embedded Jetty-server med Jersey.
// This is the applications webserver. It is an embedded Jetty server with Jersey
public class WebServer{
	
	// All servers must be run on a specific portnumber
	private int portnr;
	public Server server;

	
	// Constructor with portnumber as input
	public WebServer(int portnr) {
	 this.portnr = portnr;
	}
	
	
	// Method for setting up the server
	public void setup() throws Exception {
		ResourceConfig config = new ResourceConfig();
		config.packages("tdt4140.gr1801.web.server");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));


		Server server = new Server(this.portnr);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");
		
		this.server = server;
	}
	
	
	// Method for stopping the webserver
	public void stopServer() {
		this.server.destroy();
	}
	
	

	
}
