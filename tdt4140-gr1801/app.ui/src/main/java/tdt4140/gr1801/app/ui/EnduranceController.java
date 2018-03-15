package tdt4140.gr1801.app.ui;

import tdt4140.gr1801.app.core.Client;

public class EnduranceController implements Controller {

	
	private Client client;
	
	public EnduranceController(Client client) {
		this.client = client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
