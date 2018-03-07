package tdt4140.gr1801.app.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxLoginApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	System.out.println(getClass().getResource("FxApp.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("FxLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
