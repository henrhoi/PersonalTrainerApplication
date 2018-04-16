package tdt4140.gr1801.app.ui;

import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import tdt4140.gr1801.web.server.WebServer;

public class FxApp extends Application {

	
	// Method for opening FxLogin
    @Override
    public void start(Stage stage) throws Exception {
    		LoginController controller = new LoginController();
    		URL path = getClass().getResource("FxLogin.fxml");
    		SceneLoader.setScene(stage, path, controller);
    		
    }

    public static void main(String[] args) {
    		WebServer webserver = new WebServer(8080);
    		Thread thread1 = new Thread () {
    			public void run () {
    				try {
    					webserver.setup();
						webserver.server.start();
						webserver.server.join();
					} catch (Exception e) {
						e.printStackTrace();
					}
    		  }
    		};
    		//Start Webserver in own Thread
    		thread1.start();
    		//Launch application
    		launch(args);
    		//Stop server after application is terminated
    		try {
				webserver.server.stop();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

    }
}
