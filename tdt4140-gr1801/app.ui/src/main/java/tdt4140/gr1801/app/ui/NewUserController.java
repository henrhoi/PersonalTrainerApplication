package tdt4140.gr1801.app.ui;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tdt4140.gr1801.app.core.PersonalTrainer;





public class NewUserController {
	
	@FXML 
	TextField usernameField, firstNameField, lastNameField, phoneNumberField, emailField;
	
	@FXML 
	PasswordField passwordField, confirmPasswordField;
	
	
	//Action on createUserButton
	@FXML
	public void createUser() {
		
		//List of all fields in view
		ArrayList<TextField> fields = new ArrayList<TextField>(
				Arrays.asList(usernameField,firstNameField, lastNameField, phoneNumberField, emailField));
		
		//Check all fields for errors
		ArrayList<Boolean> results = PersonalTrainer.checkAllFields(fields);
		
		//TODO Show errors in view
		for(int i = 0; i < fields.size(); i++) {
			if(!results.get(i)) {
				//Temporary just a print
				System.err.println("Error in " + fields.get(i).getId());
			}
		}
		
		//Check password-confirmation
		if(!passwordField.getText().equals(confirmPasswordField.getText())){
			results.add(false);
			System.err.println("Password not the same");
		}
		
		
		//If all fields is valid, go back to login
		Set<Boolean> set = new HashSet<Boolean>(results);
		set.addAll(results);
		if (set.size() == 1 && set.contains(true)) {
			//TODO - Create new user object and save user.
			backToLogin(results);
		}
		
	}
	
	public void backToLogin(ArrayList<Boolean> results) {
		Parent root;
		Stage stage = (Stage)this.usernameField.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("FxLogin.fxml"));
			Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
