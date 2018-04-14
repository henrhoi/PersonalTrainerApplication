package tdt4140.gr1801.app.ui;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;


import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.PersonalTrainer;
import tdt4140.gr1801.app.core.pdfcreator.PdfCreator;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.DayProgram;
import tdt4140.gr1801.app.core.Exercise;


public class ProgramController implements TabController {
	
	
	@FXML
	ListView<DayProgram> listview;
	
    @FXML
    TableView<Exercise> tableview;
    
    @FXML
    TableColumn<Exercise, String> colName, colWeight, colSets, colReps;
	
    @FXML
    TextField distance_field, duration_field, speed_field;
    
    @FXML TextArea description_field;
    
    
	private Client client;
	private PersonalTrainer pt;
	
	@FXML
	Button exportButton;
	
	public ProgramController(PersonalTrainer pt, Client client) {
		this.client = client;
		this.pt = pt;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@FXML
	public void exportPdf() {
		//Get the stage to open DirectoryChooser in
		Stage stage = (Stage) exportButton.getScene().getWindow();
		
		//Open DirectoryChooser and save path
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choose Export Location");
		final File selectedDirectoryPath = directoryChooser.showDialog(stage);   
		
        //Create the new document if path not null
        if (selectedDirectoryPath != null) {
        	LocalDateTime date = LocalDateTime.now();
        	Document doc = PdfCreator.getNewDocument(selectedDirectoryPath.toString() + "/" 
        	+ client.getName() + "_" + date.getDayOfMonth() + "_" + date.getMonthValue() + "_" + date.getYear() + ".pdf");
        	try {
        		//Add all the data to the document
        		PdfCreator.addMetaData(doc, "TrainingProgram_" + client.getName(), "Training", new ArrayList<String>(Arrays.asList("Training")), "PTApp", "PTApp");
				PdfCreator.addFrontPage(doc, pt, client);
				PdfCreator.addContent(doc);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
        	finally {
        		//Always close the document
				doc.close();
			}
        }
        
        
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
		//days.remove(0); // First is duplicated because of some reason
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
		
		if (day == null || day.getExercises() == null) {
			tableview.setItems(null);
		}
		
		else if (day.getExercises() != null) {
			ObservableList<Exercise> items = FXCollections.observableArrayList ();
			for (Exercise exercise : day.getExercises()) {
				items.add(exercise);
			}
			tableview.setItems(items);
		}
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
	
	
	@FXML
	public void editEndurance() throws IOException {
		// Innsetting av weeklyprogram
		DayProgram dp = new DayProgram("Monday", 120, 12.0, 6.5, "Intervaller 4x4", null);
		client.createWeeklyProgram(dp);
	}
	
	@FXML 
	public void editStrength() {
		
	}
	
	@FXML
	public void updateProgram() throws IOException {
		Exercise e1 = new Exercise("Benchpress", 80, Arrays.asList(5, 5, 5, 5, 5));
    	Exercise e2 = new Exercise("Deadlift", 120, Arrays.asList(12, 10, 8));
    	ArrayList<Exercise> exercises = new ArrayList<>();
    	exercises.add(e1);
    	exercises.add(e2);
    	DayProgram dp = new DayProgram("Wednesday", null, null, null, null, exercises);
    	client.createWeeklyProgram(dp);
	}

}
