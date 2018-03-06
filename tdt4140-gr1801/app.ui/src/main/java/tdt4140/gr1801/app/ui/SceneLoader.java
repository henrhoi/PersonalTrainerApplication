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
	        stage.show();
	        System.out.println("Sucess");
		} catch (IOException e) {
			System.out.println("En feil skjedde når du prøvde åpne fxmlfilen.");
			e.printStackTrace();
		}
	}
	
	
}
