package tdt4140.gr1801.app.ui;


import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.Strength;
import tdt4140.gr1801.app.core.Exercise;

// Date
// Duration
// Name, Set, Reps

public class StrengthController implements TabController {
	
	@FXML
	TextField duration_field;
	
	@FXML
	ListView<Strength> strength_list;
	
	
    @FXML
    TableView<Exercise> table_view;
    
    @FXML
    TableColumn<Exercise, String> colName;
    
    @FXML
    TableColumn<Exercise, String> colSets;
    
    @FXML
    TableColumn<Exercise, String> colReps;


	Client client;
	
	public StrengthController(Client client) {
		this.client = client;
	}
	
	public void initialize() {
		
	}

	
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public void updateInfo() {
		// Adding the client's endurance-trainings in the listview
		ObservableList<Strength> strengthItems = FXCollections.observableArrayList ();
		for (Strength strength : client.getStrengthList()) {
			strengthItems.add(strength);
		}
		strength_list.setItems(strengthItems);
		
		// Setting the other fields in the UI
		Strength e = client.getStrengthList().get(0);
		duration_field.setText(String.valueOf(e.getDuration()));
		
		ObservableList<Exercise> exItems = FXCollections.observableArrayList ();
		for (Exercise exercise : e.getExercises()) {
			exItems.add(exercise);
		}
		table_view.setItems(exItems);
		
		
		this.table_view.setItems(exItems);
		
		this.colName = new TableColumn<Exercise, String>("Name");
		this.colName.setCellValueFactory(new PropertyValueFactory("Name"));
		
		this.colSets = new TableColumn<Exercise, String>("Sets");
		this.colSets.setCellValueFactory(new PropertyValueFactory("Sets"));
		
		this.colReps = new TableColumn<Exercise, String>("Sets");
		this.colReps.setCellValueFactory(new PropertyValueFactory("Sets"));
		
		this.table_view.getColumns().setAll(this.colName, this.colSets, this.colReps);
		
		
		
		
		/*
		 ObservableList<Person> teamMembers = ...;
		 table.setItems(teamMembers);
	
		 TableColumn<Person,String> firstNameCol = new TableColumn<Person,String>("First Name");
		 firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
		 TableColumn<Person,String> lastNameCol = new TableColumn<Person,String>("Last Name");
		 lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
	
		 table.getColumns().setAll(firstNameCol, lastNameCol);
		*/
	}

}
