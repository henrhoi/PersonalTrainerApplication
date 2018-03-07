package tdt4140.gr1801.app.ui;



import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainViewController implements Controller{
	
	@FXML
	ImageView picture;
	
	@FXML
	Tab overviewTab, strengthTab, enduranceTab, healthTab, programTab;
	
	@FXML
	Button logOffButton, addClientButton;
	
	@FXML
	Label label;
	
	private String username = "";
	

	
	public void initialize() {
	}
	
	public MainViewController(String username) {
		this.username = username;
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
	
	public void updateInfo() {
		//User this.username to update all the information
		System.out.println("Update information for " + this.username);
		label.setText(this.username);
		setTab("FxStrength.fxml", strengthTab);
		setTab("FxEndurance.fxml", enduranceTab);
		setTab("FxHealth.fxml", healthTab);
		setTab("FxProgram.fxml", programTab);
	}
	
	
     
	
	

	
}
