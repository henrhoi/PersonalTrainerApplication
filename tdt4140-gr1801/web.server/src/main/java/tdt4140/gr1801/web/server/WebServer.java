package tdt4140.gr1801.web.server;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;


// Dette er WebServeren som kommer til aa bli brukt i prosjektet. Det er en embedded Jetty-server med Jersey.
public class WebServer{
	
	// Alle servere kjoerer paa et spesifikt portnr.
	private int portnr;
	public Server server;

	public WebServer(int portnr) {
	 this.portnr = portnr;
	}
	
	public void setup() throws Exception {
		ResourceConfig config = new ResourceConfig();
		config.packages("tdt4140.gr1801.web.server");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));


		Server server = new Server(this.portnr);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");
		
		this.server = server;
		
		/*
		try {
		     server.start();
		     server.join();
		 } finally {
		     server.destroy();
		 }
		*/
		
	}
	
	// Starter en WebServer paa port 8080
	public static void main(String[] args) throws Exception {
		WebServer webserver = new WebServer(8080);
		webserver.setup();
		webserver.server.start();
		//I TESTER HA .join PAA SLUTTEN - DEN VENTER Paa AT THREADEN SKAL BLI FERDIG 
		webserver.server.join();
	}
}
