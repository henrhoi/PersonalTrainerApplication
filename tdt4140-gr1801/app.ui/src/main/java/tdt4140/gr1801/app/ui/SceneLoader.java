package tdt4140.gr1801.app.ui;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//This Class was made only for making a static method to set scenes.
public class SceneLoader {
	
	public static void setScene(Stage stage, URL path, Controller controller) {
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(path);
			loader.setController(controller);
			root = (Parent)loader.load();
			Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setMinHeight(500);
	        stage.setMinWidth(700);
	        stage.show();
	        System.out.println("Success");
		} catch (IOException e) {
			System.out.println("En feil skjedde naar du provde aapne fxmlfilen.");
			e.printStackTrace();
		}
	}
	
	
}
