package tdt4140.gr1801.app.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.Nutrition;

public class HealthController implements Controller {
	
	@FXML
	PieChart NutritionPieChart;
	
	@FXML
	ListView<String> nutritions;
	
	private Client client;
	
	public HealthController(Client client) {
		this.client = client;
		System.out.println(nutritions);
	}
	
	public void setClient(Client client) {
		this.client = client;
		updateInfo();
	}
	
	@FXML
	public void updateInfo() {
		
		ObservableList<String> nutritionItems = FXCollections.observableArrayList ();
		for(Nutrition nutrition : this.client.getNutritionList()) {
			System.out.println(nutrition.getProtein());
			nutritionItems.add(nutrition.getDate());
		}
			
		nutritions.setItems(nutritionItems);
		System.out.println(nutritionItems.size());
		Nutrition firstNutrition = this.client.getNutritionList().get(0);
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
			new PieChart.Data("Fat", 10),
			new PieChart.Data("Calories", 10),
			new PieChart.Data("Protein", 10)
		);
		NutritionPieChart.setTitle(firstNutrition.getDate());
		NutritionPieChart.setData(pieChartData);
	}

}
