package tdt4140.gr1801.app.ui;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.Endurance;



public class EnduranceController implements Controller{
	
	
	@FXML
	TextField distance_field, duration_field, avg_speed_field, cal_burned_field;
	
	@FXML
	ListView<Endurance> endurance_list;
	
	Client client;
	
	
	public EnduranceController(Client client) {
		setClient(client);
	}
	
	@Override
	public void setClient(Client client) {
		this.client = client;
		
	}
	
	public void updateInfo() {
		// Adding the client's endurance-trainings in the listview
		ObservableList<Endurance> items = FXCollections.observableArrayList ();
		for (Endurance endurance : client.getEnduranceList()) {
			items.add(endurance);
		}
		endurance_list.setItems(items);
		
		// Setting the other fields in the UI
		Endurance e = client.getEnduranceList().get(0);
		System.out.println(distance_field);
		distance_field.setText(String.valueOf(e.getDistance()));
		duration_field.setText(String.valueOf(e.getDuration()));
		avg_speed_field.setText(String.valueOf(e.getAverageSpeed()));
		cal_burned_field.setText(String.valueOf(e.getCaloriesBurned()));
		
	}
	
	

}
