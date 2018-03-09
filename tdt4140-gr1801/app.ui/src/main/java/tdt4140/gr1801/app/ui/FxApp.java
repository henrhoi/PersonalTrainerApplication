package tdt4140.gr1801.app.ui;

import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;

public class FxApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    		LoginController controller = new LoginController();
    		URL path = getClass().getResource("FxLogin.fxml");
    		SceneLoader.setScene(stage, path, controller);
    		
    }

    public static void main(String[] args) {
        launch(args);
    }

	
}
