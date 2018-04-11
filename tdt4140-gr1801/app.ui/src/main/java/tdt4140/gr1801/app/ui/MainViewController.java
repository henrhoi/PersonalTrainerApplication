package tdt4140.gr1801.app.ui;


import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.PersonalTrainer;

public class MainViewController implements Controller{
	
	@FXML
	Tab overviewTab, strengthTab, enduranceTab, healthTab, programTab;
	
	@FXML
	Button logOffButton, addClientButton;
	
	@FXML
	Label nameOfClient,nameOfPT;
	
	@FXML
	ListView<Client> clients;
	
	@FXML
	HBox buttonBox;
	
	@FXML
	Text nameOfPTInfo, birthdayOfPTInfo, phoneOfPTInfo, mailOfPTInfo;
	
	@FXML
	Pane PTInfoPane;
	
	@FXML
	AnchorPane clientsPane;
	
	

	private PersonalTrainer pt;
	//This set should contain controllers for all the tabs
	private Set<TabController> tabControllers;
	
	
	//We make a list of all the controllers that is made on updateinfo
	//when then make methods for changeClient(client) for controllers like EnduraceController etc
	
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
			client.getClientWeightFat();
			
		}
		tabControllers = new HashSet<TabController>();
	}
	
	//Used in initialize for setting which fxml-file to open in which tab
	private void setTab(String fxml, Tab tab) {
		try {
			TabController controller;
			//Temp - if there is a client, send the first client in the list.
			//Will be taken care of in a later issue
			Client client = pt.getClientList().isEmpty() ? null : pt.getClientList().get(0);
			//Choose correct controller
			switch (fxml) {
			case "FxStrength.fxml": controller = new StrengthController(client);break;
			case "FxEndurance.fxml": controller = new EnduranceController(client);break;
			case "FxHealth.fxml": controller = new HealthController(client);break;
			case "FxProgram.fxml": controller = new ProgramController(client);break;
			case "FxOverview.fxml": controller = new OverviewController(client);break;
			default:controller = null;break;//Would crash
			}
			
			//Add to tabControllers
			tabControllers.add(controller);
			//Load the fxml and add controller. Set tab content.
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
			loader.setController(controller);
			Parent root = (Parent)loader.load();
			tab.setContent(root);
			controller.startup();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void logOff() {
		Stage stage = (Stage) logOffButton.getScene().getWindow();
		LoginController controller = new LoginController();
		URL path = getClass().getResource("FxLogin.fxml");
		SceneLoader.setScene(stage, path, controller);
	}
	
	@FXML
	public void addClient() {
		Stage stage = (Stage) addClientButton.getScene().getWindow();
		Controller controller = new AddClientController(pt, this);
		URL path = getClass().getResource("FxAddClient.fxml");
		SceneLoader.setScene(stage, path, controller);
		((AddClientController) controller).update();
		
	}
	
	@FXML
	public void hideClientList() {
		if(clientsPane.isVisible()) {
			buttonBox.toBack();
		}
		else {
			buttonBox.toFront();
		}
		clientsPane.setVisible(!clientsPane.isVisible());
		PTInfoPane.toBack();
	}
	
	@FXML
	public void movePTInfoPane() {
		PTInfoPane.toFront();
	}
	
	//This method should be used when we add functionality for choosing clients inn a menu
	public void changeClientInTabs(Client client) {
		for(TabController c : tabControllers) {
			c.setClient(client);
			c.updateInfo();
		}
	}
	
	public void setClientListviewNavigationLogic(){
		// Adding logic for updating view when different trainings gets selected.
		// Mouseclick
		clients.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Getting the selected endurance training
				Client selected = clients.getSelectionModel().getSelectedItem();
				// Setting data in the view thereafter
				changeClientInTabs(selected);
				nameOfClient.setText(selected.getName());
				hideClientList();
			}
		});

		// Keyboard (up- and down-arrows)
		clients.setOnKeyReleased(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// Getting the selected endurance training
				Client selected = clients.getSelectionModel().getSelectedItem();
				if(selected == null) {
					selected = pt.getClientList().get(0);
				}
				// Setting data in the view thereafter
				changeClientInTabs(selected);
				nameOfClient.setText(selected.getName());
				hideClientList();
			}
		});

	}
	
	
	//You could say that this method is the same as init
	public void updateInfo() {
		//User this.username to update all the information
		System.out.println("Update information for " + this.pt.getUsername());
		nameOfPT.setText(pt.getName());
		
		//Set PTInfoPage
		nameOfPTInfo.setText(pt.getName());
		birthdayOfPTInfo.setText(pt.getBirthday());
		mailOfPTInfo.setText(pt.getEmail());
		phoneOfPTInfo.setText(pt.getPhoneNumber());
		
		
		//Create list view of Clients.
		ObservableList<Client> observableClients = FXCollections.observableArrayList ();
		for(Client client : pt.getClientList()) {
			observableClients.add(client);
		}
		clients.setItems(observableClients);
		if (!observableClients.isEmpty()) {
			setTab("FxStrength.fxml", strengthTab);
			setTab("FxEndurance.fxml", enduranceTab);
			setTab("FxHealth.fxml", healthTab);
			setTab("FxProgram.fxml", programTab);
			setTab("FxOverview.fxml", overviewTab);
			setClientListviewNavigationLogic();
		}
	}

	
	
  
	
	

	
}
