package tdt4140.gr1801.app.ui;

import java.util.Collections;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.Exercise;
import tdt4140.gr1801.app.core.Strength;

public class ProgramController implements TabController {
	
	
	@FXML
	ListView<Strength> listview;
	
    @FXML
    TableView<Exercise> tableview;
    
    @FXML
    TableColumn<Exercise, String> colName, colWeight, colSets, colReps;
	
    @FXML
    TextField distance_field, duration_field, speed_field, description_field;
    
	private Client client;
	
	public ProgramController(Client client) {
		this.client = client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public void updateInfo() {
		fillListview();
		setNavigationLogic();
		
	}
	
	public void fillListview() {
		// Adding the client's endurance-trainings in the listview
		ObservableList<Strength> strengthItems = FXCollections.observableArrayList ();
		Collections.sort(client.getStrengthList()); // Sorting after date
		for (Strength strength : client.getStrengthList()) {
			strengthItems.add(strength);
		}
		listview.setItems(strengthItems);
	}
	
	public void setNavigationLogic() {
		// Adding logic for updating view when different trainings gets selected.
		// Mouseclick
		listview.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Getting the selected endurance training
				Strength selected = listview.getSelectionModel().getSelectedItem();
				// Setting data in the view thereafter
				updateView(selected);
			}
		});

		// Keyboard (up- and down-arrows)
		listview.setOnKeyReleased(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// Getting the selected endurance training
				Strength selected = listview.getSelectionModel().getSelectedItem();
				// Setting data in the view thereafter
				updateView(selected);
			}
		});

	}
	



	@Override
	public void startup() {

		// Connecting the columns of the tableview to attributes in Exercise
		this.colName.setCellValueFactory(new PropertyValueFactory<Exercise, String>("Name"));
		this.colWeight.setCellValueFactory(new PropertyValueFactory<Exercise, String>("Weight"));
		
		// Sets and reps are not excplicit defined as attributes in Exercise, so they must be calculated
		this.colSets.setCellValueFactory(s -> new SimpleStringProperty(Integer.toString(s.getValue().getNumberOfSets())));
		this.colReps.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getReps()));
		setNavigationLogic();
		
		
		updateView(null);
	}

}
