package tdt4140.gr1801.app.ui;


import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.DayProgram;


public class ProgramController implements TabController {
	
	
	@FXML
	ListView<DayProgram> listview;
	
    @FXML
    TableView<DayProgram> tableview;
    
    @FXML
    TableColumn<DayProgram, String> colName, colWeight, colSets, colReps;
	
    @FXML
    TextField distance_field, duration_field, speed_field;
    
    @FXML TextArea description_field;
    
    
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
		updateView(null);
		disableFields();
		
	}
	

	
	public void fillListview() {
		// Adding the client's programs in the listview
		ObservableList<DayProgram> days = FXCollections.observableArrayList ();
		for (DayProgram dayprogram : client.getDayProgramList()) {
			days.add(dayprogram);
		}
		days.remove(0); // First is duplicated because of some reason
		listview.setItems(days);
	}
	
	public void disableFields() {
		//distance_field.setDisable(true);
		distance_field.setEditable(false);
		//duration_field.setDisable(true);
		duration_field.setEditable(false);
		//speed_field.setDisable(true);
		speed_field.setEditable(false);
		//description_field.setDisable(true);
		description_field.setEditable(false);
		//tableview.setDisable(true);
		tableview.setEditable(false);
	}
	
	public void setNavigationLogic() {
		// Adding logic for updating view when different days gets selected.
		// Mouseclick
		listview.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Getting the selected day
				DayProgram selected = listview.getSelectionModel().getSelectedItem();
				// Setting data in the view thereafter
				updateView(selected);
			}
		});

		// Keyboard (up- and down-arrows)
		listview.setOnKeyReleased(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// Getting the selected day
				DayProgram selected = listview.getSelectionModel().getSelectedItem();
				// Setting data in the view thereafter
				updateView(selected);
			}
		});

	}
	

	public void updateView(DayProgram day) {
		if (day == null || day.getDistance() == null) {
			distance_field.setText("");
			duration_field.setText("");
			speed_field.setText("");
			description_field.setText("");
			//endurance_pane.setStyle("-fx-background-color: gray");
		}
		
		else if (day.getDistance() != null) {
			// It's endurance training
			distance_field.setText(String.valueOf(day.getDistance()));
			duration_field.setText(String.valueOf(day.getDuration()));
			speed_field.setText(String.valueOf(day.getAvgSpeed()));
			description_field.setText(day.getDescription());
		}
		
		if (day == null || day.getWeight() == null) {
			tableview.setItems(null);
		}
		
		else if (day.getWeight() != null) {
			ObservableList<DayProgram> items = FXCollections.observableArrayList ();
			items.add(day);
			tableview.setItems(items);
		}
	}

	
	@Override
	public void startup() {

		// Connecting the columns of the tableview to attributes in DayProgram
		this.colName.setCellValueFactory(new PropertyValueFactory<DayProgram, String>("ExerciseName"));
		this.colWeight.setCellValueFactory(new PropertyValueFactory<DayProgram, String>("Weight"));
		this.colSets.setCellValueFactory(new PropertyValueFactory<DayProgram, String>("Sets"));
		this.colReps.setCellValueFactory(new PropertyValueFactory<DayProgram, String>("Reps"));
		
		setNavigationLogic();
		updateView(null);
	}
	
	
	@FXML
	public void editEndurance() throws IOException {
		// Innsetting av weeklyprogram
		DayProgram dp = new DayProgram("Monday", 120, 12.0, 6.5, "Intervaller 4x4", null, null, null, null);
		client.createWeeklyProgram(dp);
	}
	
	@FXML 
	public void editStrength() {
		
	}

}
