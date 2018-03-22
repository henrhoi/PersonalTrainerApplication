package tdt4140.gr1801.app.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import tdt4140.gr1801.app.core.Client;

public class OverviewController implements TabController {
	
	@FXML
	Pane root;
	
	@FXML
	Label idLabel,nameLabel,heightLabel,strengthLabel,enduranceLabel,nutritionLabel;
		
	private Client client;
	
	public OverviewController(Client client) {
		this.client = client;
	}
	
	
	@Override
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public void updateInfo() {
		updatePersonas();
		updateWeightAndFatChart();
	}
	
	private void updatePersonas() {
		this.idLabel.setText(String.format("ClientID: %s", this.client.getId()));
		this.nameLabel.setText(String.format("Name: %s", this.client.getName()));
		this.heightLabel.setText(String.format("Height: %s", this.client.getHeight()));
		this.strengthLabel.setText(String.format("No. of Strengths: %s", this.client.getStrengthList().size()));
		this.enduranceLabel.setText(String.format("No. of Endurances: %s", this.client.getEnduranceList().size()));
		this.nutritionLabel.setText(String.format("No. of Nutritions: %s", this.client.getNutritionList().size()));
	}
	
	private void updateWeightAndFatChart() {
		//Make Axis for the LineChart
		final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        //Add the axis to the lineChart
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
        //Set the title and change the size
        lineChart.setTitle("Client's weigth and fat measurements");
        lineChart.setMaxSize(450, 340);
        //Set the position
        lineChart.setLayoutX(200);
        lineChart.setLayoutY(10);
        
        //Remove other LineCharts
        root.getChildren().setAll((root.getChildren().stream().filter(n -> !(n instanceof LineChart)).collect(Collectors.toList())));
        //Add the LineChart to the view
        root.getChildren().add(lineChart);
        
        //Make a series of Datapoints for the weights
        List<String> dates;
        
		XYChart.Series<String,Number> serie1 = new XYChart.Series<String,Number>();
		serie1.setName("Weight");
		Map<String,Double> weights = client.getWeightMap();
		dates = new ArrayList<String>(weights.keySet());
		Collections.sort(dates);
		dates.stream().forEach(date -> serie1.getData().add(new XYChart.Data<String,Number>(date,weights.get(date))));
		
		//Make a series of Datapoints for the fats
		XYChart.Series<String,Number> serie2 = new XYChart.Series<String,Number>();
		serie2.setName("Fat");
		Map<String,Double> fats = client.getFatMap();
		dates = new ArrayList<String>(fats.keySet());
		dates.stream().forEach(date -> serie2.getData().add(new XYChart.Data<String,Number>(date,fats.get(date))));
		
		//Add the series of datapoints to the LineChart
		lineChart.getData().addAll(serie1,serie2);	
	}


	@Override
	public void startup() {
		// 
		
	}

}
