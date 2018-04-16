package tdt4140.gr1801.app.ui;

import tdt4140.gr1801.app.core.Client;

//This interface is used for all TabControllers. We save all the tabcontrollers in a set, so that it is easy to update them if we change Client.
public interface TabController extends Controller{
	
	//In all tabControllers this method should change this.client,
	//but also update the view in the tab so that it fit the clientdata
	public void setClient(Client client);
	
	//This method should update the view in the fxml
	//The data can be found in the Client object
	public void updateInfo();
	
	public void startup();

}
