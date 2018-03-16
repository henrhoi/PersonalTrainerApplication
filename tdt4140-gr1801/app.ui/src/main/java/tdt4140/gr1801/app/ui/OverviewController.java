package tdt4140.gr1801.app.ui;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import tdt4140.gr1801.app.core.Client;

public class OverviewController implements TabController {
	
	@FXML
	LineChart weightChart;
		
	private Client client;
	
	public OverviewController(Client client) {
		this.client = client;
	}
	
	
	@Override
	public void setClient(Client client) {
		this.client = client;
		updateInfo();

	}

	@Override
	public void updateInfo() {
		for(Double weight : client.getWeightMap().values()) {
			
		}
		
		
	}

}
