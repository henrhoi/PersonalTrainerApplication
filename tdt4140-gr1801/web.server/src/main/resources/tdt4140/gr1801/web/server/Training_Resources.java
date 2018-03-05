package tdt4140.gr1801.web.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// TODO - Faa alle styrkeoektene - samt oevelser(?) til en client

// TODO - Faa alle utholdenhetsoektene til en client


@Path("/training")
public class Training_Resources {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";

	}
}
