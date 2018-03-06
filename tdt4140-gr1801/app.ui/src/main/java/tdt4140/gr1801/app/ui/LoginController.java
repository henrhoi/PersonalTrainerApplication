package tdt4140.gr1801.app.ui;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tdt4140.gr1801.web.server.LoginModule;

public class LoginController implements Controller{
	
	@FXML
	TextField usernameField;
	
	@FXML
	PasswordField passwordField;
	
	@FXML
	Label loginInfo;
	
	//Action on enter from passwordField
	@FXML
	public void loginAction() throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		//TODO - Check if username and password are OK
		String username = usernameField.getText();
		String password = passwordField.getText();
		if(LoginModule.checkLogin(username, password)) {
			//Get current Stage
			Stage stage = (Stage)this.usernameField.getScene().getWindow();
			//Get FXML-file
			URL path = getClass().getResource("FxMainView.fxml");
			//Make the new Controller
			MainViewController controller = new MainViewController(username);
			SceneLoader.setScene(stage, path, controller);
			
			//Update all the information for current loggedIn user.
			controller.updateInfo();
		}
		else {
			loginInfo.setVisible(true);
			ObservableList<String> userstyle = usernameField.getStyleClass();
			ObservableList<String> passwordstyle = passwordField.getStyleClass();
			if(!userstyle.contains("error")) {
				userstyle.add("error");
				passwordstyle.add("error");
			}
			
		}
		
	}
	
	//Action when pressing newUserButton
	@FXML
	public void newUserAction() {
		NewUserController controller = new NewUserController();
		Stage stage = (Stage)this.usernameField.getScene().getWindow();
		URL path = getClass().getResource("FxNewUser.fxml");
		SceneLoader.setScene(stage, path, controller);
	}
	
	

}
