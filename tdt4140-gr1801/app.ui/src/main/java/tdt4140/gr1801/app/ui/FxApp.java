package tdt4140.gr1801.app.ui;

import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import tdt4140.gr1801.web.server.WebServer;

public class FxApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    		LoginController controller = new LoginController();
    		URL path = getClass().getResource("FxLogin.fxml");
    		SceneLoader.setScene(stage, path, controller);
    		
    }

    public static void main(String[] args) {
    		Thread thread1 = new Thread () {
    			public void run () {
    				WebServer webserver = new WebServer(8080);
    				try {
    					try {
    						webserver.setup();} catch (Exception e) {e.printStackTrace();}
    						System.out.println("Setting up server");
        				try {webserver.server.start();} catch (Exception e) {e.printStackTrace();}
        					System.out.println("Server started");
        				try {webserver.server.join();} catch (InterruptedException e) {e.printStackTrace();}	
    				} finally {
    					webserver.stopServer();
    					System.out.println("Server stopped");
    				}
    		  }
    		};
    		thread1.start();
    		launch(args);
    }
   

}
