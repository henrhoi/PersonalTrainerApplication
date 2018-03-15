package tdt4140.gr1801.app.ui;

import tdt4140.gr1801.app.core.Client;

public class StrengthController implements Controller {
	
	
	private Client client;
	
	public StrengthController(Client client) {
		this.client = client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
