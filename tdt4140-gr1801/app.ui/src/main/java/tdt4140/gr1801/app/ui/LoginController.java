package tdt4140.gr1801.app.ui;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tdt4140.gr1801.web.server.LoginModule;

public class LoginController {
	
	@FXML
	TextField usernameField;
	
	@FXML
	PasswordField passwordField;
	
	@FXML
	Label loginInfo;

	
	public void initialize() {
		
	}
	
	
	//Action on enter from passwordField
	@FXML
	public void loginAction() throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		//TODO - Check if username and password are OK
		String username = usernameField.getText();
		String password = passwordField.getText();
		if(LoginModule.checkLogin(username, password)) {
			openNewFXML("FxMainView.fxml");
		}
		else {
			loginInfo.setText("Wrong username or password");
		}
		
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
