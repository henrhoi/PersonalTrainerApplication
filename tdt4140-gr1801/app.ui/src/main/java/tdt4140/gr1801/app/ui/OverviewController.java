package tdt4140.gr1801.app.ui;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.client.ClientProtocolException;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import tdt4140.gr1801.app.core.Client;


// tester popupvindu
import tdt4140.gr1801.app.ui.PasswordDialog;
import tdt4140.gr1801.web.server.LoginModule;

import java.util.Optional;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

//
public class OverviewController implements TabController {
	
	@FXML
	Pane root;
	
	@FXML
	Label idLabel,nameLabel,heightLabel,strengthLabel,enduranceLabel,nutritionLabel, errorLabel;
		
	@FXML
	Button deleteClientButton; 
	
	private Client client;
	private MainViewController mainviewController; 
	
	public OverviewController(Client client, MainViewController mainviewController) {
		this.client = client;
		this.mainviewController = mainviewController;
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
        lineChart.setPrefSize(600, 480);
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

	// definerer streng for å lagre passord som skrives inn for at klient skal kunne slettes 
	private String inputPassword = "";
	@FXML
	public void deleteClient() throws NoSuchAlgorithmException, ClientProtocolException, IOException {
		// skal lage popup-vindu som skal ta inn ting
		// skal sjekke passord -- rød tekst hvis ikke
		// kalle funksjon for å slette klient hos pt (pt.deleteClient ) 
		// må slette klient fra liste i app 
		    PasswordDialog pd = new PasswordDialog();

		    Optional<String> result = pd.showAndWait();
			result.ifPresent(password -> {this.inputPassword=password;});
			System.out.println("Password : "+this.inputPassword);
			if(LoginModule.checkLogin(this.client.getPersonalTrainer(), this.inputPassword)){
				//ObservableList<String> buttonStyle = deleteClientButton.getStyleClass();
				//if(buttonStyle.contains("error")) {
				//	buttonStyle.remove("error");
				System.out.println("Riktig passord");
			
				
				this.client.getPersonalTrainerObject().deleteClient(this.inputPassword, this.client.getId());
				Stage stage = (Stage)idLabel.getScene().getWindow();
				URL path = getClass().getResource("FxMainView.fxml");
				SceneLoader.setScene(stage, path, this.mainviewController);
				this.mainviewController.updateInfo();
			
				// mangler: 
				// maa slette i liste i MainView også 
			} else {
				ObservableList<String> buttonStyle = deleteClientButton.getStyleClass();
				deleteClientButton.setStyle("    -fx-border-radius: 6;" + 
						"    -fx-border-color: red;" + 
						"    -fx-border-width: 1;" + 
						"    -fx-background-radius: 6;");
				errorLabel.setVisible(true);
				Thread thread = new Thread () {
					public void run() {
						try {
							Thread.sleep(1600);
							deleteClientButton.setStyle("    -fx-border-radius: 6;" + 
									"    -fx-border-color: black;" + 
									"    -fx-border-width: 1;" + 
									"    -fx-background-radius: 6;");
							errorLabel.setStyle("-fx-text-fill: red;");
							errorLabel.setVisible(false);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				thread.start();
				System.out.println("Feil passord");
			}
				
			}
	


	

	
	
	@Override
	public void startup() {
		// 
		
	}
}



