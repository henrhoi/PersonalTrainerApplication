package tdt4140.gr1801.app.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.Nutrition;

public class HealthController implements TabController {
	
	@FXML
	PieChart NutritionPieChart;
	
	@FXML
	ListView<Nutrition> listview;
	
	private Client client;
	
	
	
	public HealthController(Client client) {
		this.client = client;
		System.out.println(listview);
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@FXML
	public void updateInfo() {
		fillListview();
		setNavigationLogic();
		NutritionPieChart.setTitle("OVERSKRIFT");
		
		
	}
	
	public void fillListview() {
		ObservableList<Nutrition> nutritionItems = FXCollections.observableArrayList ();
		for(Nutrition nutrition : this.client.getNutritionList()) {
			nutritionItems.add(nutrition);
		}
		listview.setItems(nutritionItems);
	}
	
	public void setNavigationLogic() {
		// Adding logic for updating view when different nutrition-dates gets selected.
		// Mouseclick
		listview.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Getting the selected nutrition
				Nutrition selected = listview.getSelectionModel().getSelectedItem();
				// Setting data in the view thereafter
				updateView(selected);
			}
		});

		// Keyboard (up- and down-arrows)
		listview.setOnKeyReleased(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// Getting the selected nutrition
				Nutrition selected = listview.getSelectionModel().getSelectedItem();
				// Setting data in the view thereafter
				updateView(selected);
			}
		});

	}
	
	public void updateView(Nutrition n) {
		ObservableList<Data> pieChartData = FXCollections.observableArrayList(
				new Data("Fat", n.getFat()),
				new Data("Calories", n.getCalories()),
				new Data("Protein", n.getProtein()),
				new Data("Carbs", n.getCarbs())
			);
		NutritionPieChart.setData(pieChartData);
		
		/*
		 Below is an attempt to not make new data-objects everytime, but to just update them instead. 
		 In that case one must first only initialize the pieChartData-observablelist with 
		 0 values for fat, calories, etc. setNavigationLogic() makes sure that everytime you click/switch
		 to another nutrition-object in the listview, this method will be called and the piechart updated.
		 The below code does currently not work as the fields in the pieChart do not change from their initial value. 
		*/
		
//		for (Data d : pieChartData) {
//			switch (d.getName()) {
//				case ("Fat"): d.setPieValue(n.getFat());
//				case ("Calories"): d.setPieValue(n.getCalories());
//				case ("Protein"): d.setPieValue(n.getProtein());
//				case ("Carbs"): d.setPieValue(n.getCarbs());
//			}
//		}
//		NutritionPieChart.setData(pieChartData);

	}

}
