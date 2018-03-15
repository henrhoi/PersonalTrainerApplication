package tdt4140.gr1801.app.ui;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.Nutrition;
import tdt4140.gr1801.app.core.PersonalTrainer;

public class NutritionController {
	
	@FXML
	PieChart nutritionData;
	
	@FXML
	Button updatebutton;
	
	@FXML
	ListView<Nutrition> nutritions;
	
	Client client;
	List<Nutrition> clientNutrition;
	
	public NutritionController(Client client) throws ClientProtocolException, IOException {
		this.client = client;
		this.clientNutrition = client.getNutrition();
				
		// TODO Auto-generated constructor stub
	}
	
	public void updateInfo() {
		
		
		ObservableList<Nutrition> nutritionItems =FXCollections.observableArrayList ();
		for(Nutrition nutrition : this.client.getNutrition()) {
			nutritionItems.add(nutrition);
		}
		nutritions.setItems(nutritionItems);
	
		Nutrition firstNutrition = this.clientNutrition.get(0);
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Fat", 10),
				new PieChart.Data("Calories", 10),
				new PieChart.Data("Protein", 10)
				);
		nutritionData.setTitle(firstNutrition.getDate());
		nutritionData.setData(pieChartData);
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		PersonalTrainer pt = new PersonalTrainer("henrhoi","Vilde", "Arntzen", "vildera@stud.ntnu.no","90959409","19970603");
		Client client = new Client(2,"Vilde Arntzen",160, pt);
		client.getClientNutrition();
		System.out.println(client.getNutrition().get(0).getDate());
	}
}
