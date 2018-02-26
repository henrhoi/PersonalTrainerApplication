package tdt4140.gr1801.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	TextField usernameField;
	
	@FXML
	PasswordField passwordField;
	

	
	public void initialize() {
		
	}
	
	
	//Action on enter from passwordField
	@FXML
	public void loginAction() {
		//TODO - Check if username and password are OK
		openNewFXML("FxMainView.fxml");
	}
	
	
	//Action on newUserButton
	@FXML
	public void newUserAction() {
		openNewFXML("FxNewUser.fxml");
	}
	
	public void openNewFXML(String fxmlName) {
		Parent root;
		Stage stage = (Stage)this.usernameField.getScene().getWindow();
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
