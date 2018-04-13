package tdt4140.gr1801.app.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.client.ClientProtocolException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import tdt4140.gr1801.app.core.Client;

public class OverviewController implements TabController {
	
	@FXML
	Pane root;
	
	@FXML
	AnchorPane infoTab;
	
	
	@FXML
	Label idLabel,nameLabel,heightLabel,strengthLabel,enduranceLabel,nutritionLabel, beforeDateLabel, afterDateLabel;
	
	@FXML
	ListView<String> pictureDates;
	
	@FXML
	Tab InfoTab, ProgressionTab;
	
	@FXML
	ImageView beforeImage, afterImage;
	
		
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
		updatePictures();
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
        lineChart.setPrefSize(600, 480);
        //Set the position
        lineChart.setLayoutX(200);
        lineChart.setLayoutY(50);
        
        //Remove other LineCharts
        
        infoTab.getChildren().setAll((infoTab.getChildren().stream().filter(n -> !(n instanceof LineChart)).collect(Collectors.toList())));
        //Add the LineChart to the view
        infoTab.getChildren().add(lineChart);
        
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
	
	
	@SuppressWarnings("deprecation")
	@FXML
	public void updatePictures() {
		
		List<String> myDates = this.client.getPictureDates();
		//Getting picture dates
		ObservableList<String> dates = FXCollections.observableArrayList();
		for(String date : myDates) {
			dates.add(getDateString(date));	
		}
		
		if(myDates.isEmpty()) {
			System.out.println("e");
			this.pictureDates.setItems(FXCollections.observableArrayList(""));
		}
			
		else{
			this.pictureDates.setItems(dates);
		}
		
		//setting the before image
		if(myDates.size() > 0) {
			Image image = this.client.getImage(myDates.get(0));
			beforeImage.setImage(image);
			beforeDateLabel.setText(getDateString(myDates.get(0)));
			
		}
		
		else {
			//Just an emty image
			Image image = new Image("https://stmichaelsknightsofcolumbus.com/wordpress/wp-content/uploads/2013/08/Photo-not-available.jpg");
			beforeImage.setImage(image);
			afterImage.setImage(image);
			
		}
		
		//setting the after image. Will add event handler for changing image
		if(myDates.size() == 1)  {			
			afterImage.setImage(new Image("https://stmichaelsknightsofcolumbus.com/wordpress/wp-content/uploads/2013/08/Photo-not-available.jpg"));
			
		}
		else if(myDates.size() > 1) {
			afterImage.setImage(this.client.getImage(myDates.get(1)));
			afterDateLabel.setText(getDateString(myDates.get(1)));
		}
	}
	
	
	public void addPictureNavigationLogic() {
		
		//When you choose an element, it will change the picture to that element.
		pictureDates.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				String date = pictureDates.getSelectionModel().getSelectedItem();
				updatePicture(date);
			}
		});
		
		//arrow key kan also change picture
		pictureDates.setOnKeyReleased(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				String date = pictureDates.getSelectionModel().getSelectedItem();
				updatePicture(date);
			}
		});
	}
	
	private void updatePicture(String date) {
		afterImage.setImage(this.client.getImage(getNormalDateFormat(date)));
		afterDateLabel.setText(date);
	}

	
	public String getDateString(String date) {
		String year = date.substring(0, 4);
		String day = date.substring(8);
		switch(date.substring(5, 7)) {
		case "01": return day + ". Jan " + year;
		case "02": return day + ". Feb " + year;
		case "03": return day + ". Mar " + year;
		case "04": return day + ". Apr " + year;
		case "05": return day + ". May " + year;
		case "06": return day + ". Jun " + year;
		case "07": return day + ". Jul " + year;
		case "08": return day + ". Aug " + year;
		case "09": return day + ". Sep " + year;
		case "10": return day + ". Oct " + year;
		case "11": return day + ". Nov " + year;
		case "12": return day + ". Des " + year;
		default: return "";
		}
	}
	
	public String getNormalDateFormat(String date) {
		String year = date.substring(8);
		String day = date.substring(0,2);
		switch(date.substring(4,7)) {
		case "Jan": return year + "-01-" + day;
		case "Feb": return year + "-02-" + day;
		case "Mar": return year + "-03-" + day;
		case "Apr": return year + "-04-" + day;
		case "May": return year + "-05-" + day;
		case "Jun": return year + "-06-" + day;
		case "Jul": return year + "-07-" + day;
		case "Aug": return year + "-08-" + day;
		case "Sep": return year + "-09-" + day;
		case "Oct": return year + "-10-" + day;
		case "Nov": return year + "-11-" + day;
		case "Dec": return year + "-12-" + day;
		default: return "";
		}
	}
	
	@Override
	public void startup() {
		addPictureNavigationLogic();
		
	}

}
