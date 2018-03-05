package tdt4140.gr1801.app.ui;



import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainViewController {
	
	@FXML
	ImageView picture;
	
	@FXML
	Tab overviewTab, strengthTab, enduranceTab, healthTab, programTab;
	
	@FXML
	Button logOffButton;
	
	
	public void initialize() {
		setTab("FxStrength.fxml", strengthTab);
		setTab("FxEndurance.fxml", enduranceTab);
		setTab("FxHealth.fxml", healthTab);
		setTab("FxProgram.fxml", programTab);
		
		Image img = new Image("https://imgur.com/Qb1bf2g",89,102,true,true);
		picture.setImage(img);
		picture.setVisible(true);
		System.out.println(picture.isVisible());
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
		//TODO save changes
		openNewFXML("FxLogin.fxml");
	}
	
	public void openNewFXML(String fxmlName) {
		Parent root;
		Stage stage = (Stage)this.logOffButton.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource(fxmlName));
			Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			System.out.println("hei");
			e.printStackTrace();
		}
        
	}
	
	

	
}
