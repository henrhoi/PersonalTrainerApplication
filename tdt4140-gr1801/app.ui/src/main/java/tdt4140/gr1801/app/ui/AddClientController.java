package tdt4140.gr1801.app.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.PersonalTrainer;

public class AddClientController implements Controller {
	
	@FXML
	TextField first_name_field, last_name_field, height_field;
	
	@FXML
	Button add_client_button,logOffButton;
	
	@FXML
	Label nameOfPT;
	
	PersonalTrainer pt;
	Client client;
	MainViewController mainviewController;
	
	public AddClientController(PersonalTrainer pt, MainViewController mainviewController) {
		this.pt = pt;
		this.mainviewController = mainviewController;
		
	}
	
	public void update() {
		nameOfPT.setText(pt.getName());
	}
	
	@FXML
	public void addClient() {
		
		// Check fields and include "error" in their styleclass if input is invalid
		ArrayList<TextField> fields = new ArrayList<>(Arrays.asList(first_name_field, last_name_field, height_field));
		fields.stream().forEach(f -> check(f));
		
		// Checking if the styleclass of the fields contains "error" (is unvalid input)
		// Markere ugyldige felter med r�de kanter (CSS)
		AnchorPane pane = (AnchorPane)first_name_field.getParent().getParent().getParent();
		List<Node> errors = pane.getChildren().stream().filter(f -> f.getStyleClass().contains("error")).collect(Collectors.toList());
		// Adding new client to database
		if (errors.size() == 0) {
			addClientToDatabase();
			System.out.println("Success");
			
		}
		else {
			System.err.println(errors.size() + " felter er ugyldige");
		}
		
	}
	
	private void addClientToDatabase() {
		try {
			String name = first_name_field.getText() + " " + last_name_field.getText();
			int height = Integer.parseInt(height_field.getText());
			client = new Client(0, name, height, pt);
			client.createClient();
			
			
		} catch( IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// NB: Doesn't get back to the same mainview as before
	@FXML
	public void backToMainview() {
		Stage stage = (Stage)first_name_field.getScene().getWindow();
		URL path = getClass().getResource("FxMainView.fxml");
		SceneLoader.setScene(stage, path, mainviewController);
		mainviewController.updateInfo();
		System.out.println("Back to mainview.");
		
	}
	
	@FXML
	public void logOff() {
		Stage stage = (Stage) logOffButton.getScene().getWindow();
		LoginController controller = new LoginController();
		URL path = getClass().getResource("FxLogin.fxml");
		SceneLoader.setScene(stage, path, controller);
	}
	
	private void check(TextField field) {
		boolean bool;
		ObservableList<String> style = field.getStyleClass();
		switch (field.getId()) {
		// Client should have own check methods
		case "first_name_field": bool = Client.checkFirstName(field.getText()); break;
		case "last_name_field": bool = Client.checkLastName(field.getText()); break;
		case "height": bool = Client.checkHeight((Integer.parseInt(field.getText()))); break;
		default: bool = true; break;
		}
		
		if (!bool) {
			style.add("error");
		}
		else if(style.contains("error") && bool) {
			style.remove("error");
		}
		
	}
	
	
	
	

}
