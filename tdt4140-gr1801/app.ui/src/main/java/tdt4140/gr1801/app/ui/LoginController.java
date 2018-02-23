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
	Pane ap;
	
	@FXML
	TextField usernameField;
	
	@FXML
	PasswordField passwordField;
	

	
	public void initialize() {
		
	}
	
	
	//Action on enter from passwordField
	@FXML
	public void loginAction() {
		System.out.println("loginAction");
	}
	
	
	@FXML
	public void newUserAction() {
		Stage stage = (Stage)this.usernameField.getScene().getWindow();
		System.out.println("\nHei");
		
		startNewStage(stage);
	}
	
	public void startNewStage(Stage stage) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("FxNewUser.fxml"));
			Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
