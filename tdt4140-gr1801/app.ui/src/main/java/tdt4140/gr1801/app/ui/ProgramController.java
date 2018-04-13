package tdt4140.gr1801.app.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.PersonalTrainer;
import tdt4140.gr1801.app.core.pdfcreator.PdfCreator;

public class ProgramController implements TabController {
	
	
	@SuppressWarnings("unused")
	private Client client;
	private PersonalTrainer pt;
	
	@FXML
	Button exportButton;
	
	public ProgramController(PersonalTrainer pt, Client client) {
		this.client = client;
		this.pt = pt;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@FXML
	public void exportPdf() {
		//Get the stage to open DirectoryChooser in
		Stage stage = (Stage) exportButton.getScene().getWindow();
		
		//Open DirectoryChooser and save path
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choose Export Location");
        final String selectedDirectoryPath = directoryChooser.showDialog(stage).toString();
        
        //Create the new document if path not null
        if (selectedDirectoryPath != null) {
        	Document doc = PdfCreator.getNewDocument(selectedDirectoryPath + "/nameoffile.pdf");
        	try {
        		//Add all the data to the document
        		PdfCreator.addMetaData(doc, "TrainingProgram_" + client.getName(), "Training", new ArrayList<String>(Arrays.asList("Training")), "PTApp", "PTApp");
				PdfCreator.addFrontPage(doc, pt, client);
				PdfCreator.addContent(doc);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
        	finally {
        		//Always close the document
				doc.close();
			}
        }
        
        
	}

	@Override
	public void updateInfo() {
		// 
		
	}

	@Override
	public void startup() {
		// 
		
	}

}
