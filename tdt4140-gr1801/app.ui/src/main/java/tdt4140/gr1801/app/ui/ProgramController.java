package tdt4140.gr1801.app.ui;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.fxml.FXML;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
import javafx.util.converter.DoubleStringConverter;
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
    
    @FXML 
    TextArea description_field;
    
    @FXML
	Button exportButton;//, updateProgram_button; 
    
    
	private Client client;
	private PersonalTrainer pt;	
	
	
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
				PdfCreator.addContent(doc, listview.getItems());
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
		setFieldsEditable(false);
		
	}
	

	
	public void fillListview() {
		// Adding the client's programs in the listview
		ObservableList<DayProgram> days = FXCollections.observableArrayList ();
		List<DayProgram> dayPrograms = client.getDayProgramList();
		Collections.sort(dayPrograms);
		for (DayProgram dayprogram : dayPrograms) {
			days.add(dayprogram);
		}
		//days.remove(0); // First is duplicated because of some reason
		listview.setItems(days);
	}
	
	public void setFieldsEditable(boolean value) {
		//distance_field.setDisable(true);
		distance_field.setEditable(value);
		//duration_field.setDisable(true);
		duration_field.setEditable(value);
		//speed_field.setDisable(true);
		speed_field.setEditable(value);
		//description_field.setDisable(true);
		description_field.setEditable(value);
		//tableview.setDisable(true);
		tableview.setEditable(value);
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
		//updateProgram_button.setDisable(true);
		//listview.setEditable(true);
	}
	
	
//	@FXML
//	public void editEndurance() throws IOException {
//		updateProgram_button.setDisable(false);
//		setFieldsEditable(true);
//	}
//	
//	@FXML 
//	public void editStrength() {
//		tableview.setEditable(true);
//		System.out.println("Before colname");
//		colName.setCellFactory(TextFieldTableCell.forTableColumn());
//		System.out.println("Before colweight");
//		colWeight.setCellFactory(TextFieldTableCell.forTableColumn());
//		System.out.println("Before colsets");
//		colSets.setCellFactory(TextFieldTableCell.forTableColumn());
//		System.out.println("Before colreps");
//		colReps.setCellFactory(TextFieldTableCell.forTableColumn());
//		updateProgram_button.setDisable(false);
//		System.out.println("End of editStrength-method");
//	}
	
	
	
//	@FXML
//	public void updateProgram() throws IOException {
//		if (checkEnduranceFields()) {
//			String weekday = listview.getSelectionModel().getSelectedItem().getWeekday();
//			
//			// Updated endurance info
//			int duration = duration_field.getText() == "" ? 
//					0 : Integer.parseInt(duration_field.getText());
//			double distance = distance_field.getText() == "" ?
//					0 : Double.parseDouble(distance_field.getText()) ;
//			double speed = speed_field.getText() == "" ?
//					0 : Double.parseDouble(speed_field.getText());
//			String descr = description_field.getText();
//			
//			// Updated strength info
//			List<Exercise> exercises = new ArrayList<>();
//			if (!tableview.getItems().isEmpty()) {
//				tableview.getItems().stream().forEach(e -> exercises.add(e));
//			}
//
//			DayProgram dp = new DayProgram(weekday, duration, distance, speed, descr, exercises);
//			client.createWeeklyProgram(dp);
//			updateProgram_button.setDisable(true);
//			tableview.setEditable(false);
//			colName.setEditable(false);
//			colWeight.setEditable(false);
//			colSets.setEditable(false);
//			colReps.setEditable(false);
//			
//		}
//	}
//	
//	@FXML
//	public void nameChanged(CellEditEvent<Exercise, String> event) {
//		Exercise exerciseSelected = tableview.getSelectionModel().getSelectedItem();
//		try {
//			exerciseSelected.setName(event.getNewValue());
//		} catch(Exception e) {
//			System.out.println("Name is not valid");
//		}
//	}
//	
//	@FXML
//	public void weightChanged(CellEditEvent<Exercise, String> event) {
//		Exercise exerciseSelected = tableview.getSelectionModel().getSelectedItem();
//		try {
//			exerciseSelected.setWeight(Double.parseDouble(event.getNewValue()));
//		} catch(Exception e) {
//			System.out.println("Weight is not valid");
//		}
//	}
//	
//	@FXML
//	public void setsChanged(CellEditEvent<Exercise, String> event) {
//		
//	}
//	
//	@FXML
//	public void repsChanged(CellEditEvent<Exercise, String> event) {
//		Exercise exerciseSelected = tableview.getSelectionModel().getSelectedItem();
//		String newReps = event.getNewValue();
//		try {
//			List<Integer> reps = new ArrayList<>();
//			for (int i = 0; i < newReps.length(); i+=2) {
//				reps.add(Integer.parseInt(""+newReps.charAt(i)));
//			}
//			exerciseSelected.setRepsPerSet(reps);
//		} catch(Exception e) {
//			System.out.println("Reps is not valid");
//		}
//	}
//	
//	
//	@FXML 
//	public void clearAllEndurance() {
//		distance_field.setText("");
//		duration_field.setText("");
//		speed_field.setText("");
//		description_field.setText("");
//	}
//	
//	@FXML
//	public void clearAllStrength() {
//		tableview.setItems(null);
//	}
//	
//	
//	
//	private boolean checkEnduranceFields() {
//		try {
//			if (distance_field.getText() != "" && Double.parseDouble(distance_field.getText()) < 0) {
//				return false;
//			}
//			if (duration_field.getText() != "" && Integer.parseInt(duration_field.getText()) < 0) {
//				return false;
//			}
//			if (duration_field.getText() != "" && Double.parseDouble(speed_field.getText()) < 0) {
//				return false;
//			}
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
	
}
