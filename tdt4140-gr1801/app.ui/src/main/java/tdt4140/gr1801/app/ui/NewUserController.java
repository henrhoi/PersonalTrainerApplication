package tdt4140.gr1801.app.ui;


import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import tdt4140.gr1801.app.core.PersonalTrainer;





public class NewUserController {
	
	@FXML TextField usernameField, firstNameField, lastNameField, phoneNumberField, emailField;
	@FXML PasswordField passwordField, confirmPasswordField;
	
	PersonalTrainer trainer;
	
	Background b;
	BackgroundFill bf;
	
	public void initialize() {
		this.trainer = new PersonalTrainer();
	}
	
	@FXML
	public void createUser() {

		ArrayList<TextField> fields = new ArrayList<TextField>(Arrays.asList(usernameField, firstNameField, lastNameField,
				phoneNumberField, emailField));
		
		ArrayList<Boolean> results = trainer.checkAllFields(fields);
		for(int i = 0; i < fields.size(); i++) {
			if(!results.get(i)) {
				//fields.get(i).setBackground(new Background(new BackgroundFill()));;
				System.err.println("Error in " + fields.get(i).getId());
			}
		}
		if(!passwordField.getText().equals(confirmPasswordField)){
			System.err.println("password not the same");
		}
		
	}
	
	
}
