package tdt4140.gr1801.app.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.Nutrition;

public class HealthController implements TabController {
	
	@FXML
	PieChart NutritionPieChart;
	
	@FXML
	ListView<Nutrition> listview;
	
	@FXML
	Label PieChartDataLabel;
	
	@FXML
	TextArea caloriesText;	
		
	private Client client;
	
	
	public HealthController(Client client) {
		this.client = client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@FXML
	public void updateInfo() {
		fillListview();
		updateView(null);
		
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
		if (n != null) {
			ObservableList<Data> pieChartData = FXCollections.observableArrayList(
					new Data("Fat", n.getFat()),
					new Data("Protein", n.getProtein()),
					new Data("Carbs" , n.getCarbs())
				);
			
			//Setting the title of the chart + placing the legend on the left side of the chart.
			NutritionPieChart.setTitle("Nutrition of " + n.getDate());
			NutritionPieChart.setData(pieChartData);
			NutritionPieChart.setLegendSide(Side.LEFT);
			
			// Changes the colors of the Pie chart so that they are the same every time
			applyCustomColorSequence(
				      pieChartData, 
				      "bisque", 
				      "coral", 
				      "crimson"
				    );
			NutritionPieChart.setLegendVisible(false);
			PieChartDataLabel.setText("Hover Pie Chart For Info");
			addEventHandlerPieChart();
			caloriesText.setText("Calories: " + n.getCalories());
			
		}

		else {
			NutritionPieChart.setData(FXCollections.observableArrayList());
		}
		
		
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

	@Override
	public void startup() {
		setNavigationLogic();
		//NutritionPieChart.setTitle("OVERSKRIFT");
		
	}
	
	
	//Creates an event handler every time you change the date for that date's data.

	public void addEventHandlerPieChart() {
		for(PieChart.Data data : NutritionPieChart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					PieChartDataLabel.setText(data.getName() + " - " + data.getPieValue() + " grams");
				}
			});
		}
	}
	
	//Creating custom colors for all the pies
	private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
	    int i = 0;
	    for (PieChart.Data data : pieChartData) {
	      data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
	      i++;
	    }
	  }
	
}
