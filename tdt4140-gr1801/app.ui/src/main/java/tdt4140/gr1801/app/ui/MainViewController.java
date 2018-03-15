package tdt4140.gr1801.app.ui;



import java.io.IOException;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.PersonalTrainer;

public class MainViewController implements Controller{
	
	@FXML
	ImageView picture;
	
	@FXML
	Tab overviewTab, strengthTab, enduranceTab, healthTab, programTab;
	
	@FXML
	Button logOffButton, addClientButton;
	
	@FXML
	Label label;
	
	@FXML
	ListView<Client> liste;
	
	
	private PersonalTrainer pt;
	

	
	public void initialize() {
	}
	
	public MainViewController(String username) throws ClientProtocolException, IOException {
		//Make corresponding PT object
		this.pt = new PersonalTrainer(username);
		//Get all his Clients
		pt.getPTClients(); 
		//For each client get all the clients StrengthTraings etc
		for (Client client : pt.getClientList()) {
			client.getStrengthTrainings();
			client.getClientEnduranceTraining();
			client.getClientNutrition();
			//TODO update endurance nutrition etc
		}
	}
	
	//Used in initialize for setting which fxml-file to open in which tab
	private void setTab(String fxml, Tab tab) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			tab.setContent(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void logOff() {
		Stage stage = (Stage) logOffButton.getScene().getWindow();
		LoginController controller = new LoginController();
		URL path = getClass().getResource("FxLogin.fxml");
		SceneLoader.setScene(stage, path, controller);
	}
	
	@FXML
	public void addClient() {
		//TODO update database
		System.out.println("Add Client");
	}
	
	
	//You could say that this method is the same as init
	public void updateInfo() {
		//User this.username to update all the information
		System.out.println("Update information for " + this.pt.getUsername());
		label.setText(this.pt.getUsername());
		
		//MidSoulution just to show that a pt has clients.
		ObservableList<Client> items =FXCollections.observableArrayList ();
		for(Client client : this.pt.getClientList()) {
			items.add(client);
		}
		liste.setItems(items);
		
		setTab("FxStrength.fxml", strengthTab);
		setTab("FxEndurance.fxml", enduranceTab);
		setTab("FxHealth.fxml", healthTab);
		setTab("FxProgram.fxml", programTab);
		
		
		
	}
	
	
     
	
	

	
}
