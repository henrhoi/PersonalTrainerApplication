package tdt4140.gr1801.app.ui;

import tdt4140.gr1801.app.core.Client;

public class ProgramController implements TabController {
	
	
	private Client client;
	
	public ProgramController(Client client) {
		this.client = client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public void updateInfo() {
		// TODO Auto-generated method stub
		
	}

}
