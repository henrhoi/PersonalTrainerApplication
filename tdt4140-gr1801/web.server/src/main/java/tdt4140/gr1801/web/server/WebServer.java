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

	public WebServer(int portnr) {
	 this.portnr = portnr;
	}
	
	public void run() throws Exception {
		ResourceConfig config = new ResourceConfig();
		config.packages("tdt4140.gr1801.web.server");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));


		Server server = new Server(this.portnr);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");


		try {
		     server.start();
		     server.join();
		 } finally {
		     server.destroy();
		 }
		
	}
	
	// Starter en WebServer paa port 8080
	public static void main(String[] args) throws Exception {
		WebServer webserver = new WebServer(8080);
		webserver.run();
	}
}
