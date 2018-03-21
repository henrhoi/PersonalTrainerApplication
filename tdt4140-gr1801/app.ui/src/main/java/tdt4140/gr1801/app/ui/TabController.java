package tdt4140.gr1801.app.ui;

import tdt4140.gr1801.app.core.Client;

public interface TabController extends Controller{
	
	//In all tabControllers this method should change this.client,
	//but also update the view in the tab so that it fit the clientdata
	public void setClient(Client client);
	
	//This method should update the view in the fxml
	//The data can be found in the Client object
	public void updateInfo();
	
	public void startup();

}
