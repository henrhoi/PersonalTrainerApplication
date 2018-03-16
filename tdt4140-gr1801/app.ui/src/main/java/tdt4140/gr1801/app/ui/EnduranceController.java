package tdt4140.gr1801.app.ui;


import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import jersey.repackaged.com.google.common.collect.Lists;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.Endurance;


public class EnduranceController extends ListCell<Endurance> implements TabController {
	
	
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
	
	@Override
	public void updateInfo() {
		// Adding the client's endurance-trainings to the listview
		ObservableList<Endurance> items = FXCollections.observableArrayList ();
		Collections.sort(client.getEnduranceList()); // Sorting after date
		for (Endurance endurance : Lists.reverse(client.getEnduranceList())) {
			items.add(endurance);
		}
		endurance_list.setItems(items);
		
		// Adding logic for updating view when different trainings are selected.
		endurance_list.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Getting the selected endurance training
				Endurance selected = endurance_list.getSelectionModel().getSelectedItem();
				// Setting data in the view thereafter
				updateView(selected);
			}
		});
	}
	
	public void updateView(Endurance e) {
		if (e != null) {
			distance_field.setText(String.valueOf(e.getDistance()));
			duration_field.setText(String.valueOf(e.getDuration()));
			avg_speed_field.setText(String.valueOf(e.getAverageSpeed()));
			cal_burned_field.setText(String.valueOf(e.getCaloriesBurned()));
		}
	}

	
	
	
	

}
