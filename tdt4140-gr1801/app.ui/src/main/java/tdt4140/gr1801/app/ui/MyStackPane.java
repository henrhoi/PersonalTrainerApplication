package tdt4140.gr1801.app.ui;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;


public class MyStackPane extends StackPane{
	
	LoginController loginC;
	MainViewController mainC;
	NewUserController newUserC;
	
	private Map<String,Parent> map;
	
	public MyStackPane() throws IOException {
		super();
//		loginC = new LoginController(this);
//		mainC = new MainViewController();
//		newUserC = new NewUserController();
//		
//		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("FxLogin.fxml"));
//		FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("FxMainView.fxml"));
//		FXMLLoader newUserLoader = new FXMLLoader(getClass().getResource("Fx.fxml"));
		
		
		
//		loader.setController(loginC);
//		Parent root = (Parent) loader.load();
		
//		getChildren().setAll(root);
		
		
		
		
		
//		this.map = new HashMap<String,Parent>();
//		map.put("loginView",FXMLLoader.load(getClass().getResource("FxLogin.fxml")));
//		map.put("mainView",FXMLLoader.load(getClass().getResource("FxMainView.fxml")));
//		map.put("newUserView",FXMLLoader.load(getClass().getResource("FxNewUser.fxml")));
		
//		this.map.values().stream().forEach(n -> getChildren().add(n));
//		this.map.values().stream().forEach(n -> n.setVisible(false));
//		this.map.get("loginView").setVisible(true);
		
	
	}
	
	public void setVisibleScreen() {
		
	}
	
	

}
