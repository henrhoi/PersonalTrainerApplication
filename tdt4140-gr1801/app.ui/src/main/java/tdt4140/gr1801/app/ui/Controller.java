package tdt4140.gr1801.app.ui;

import tdt4140.gr1801.app.core.Client;

//This Interface was made only to be used as a type when sending a Controller parameter to SceneLoader
//All the controllers should implement this interface
public interface Controller {
	
	//In all tabControllers this method should change this.client,
	//but also update the view in the tab so that it fit the clientdata
	public void setClient(Client client);
}
