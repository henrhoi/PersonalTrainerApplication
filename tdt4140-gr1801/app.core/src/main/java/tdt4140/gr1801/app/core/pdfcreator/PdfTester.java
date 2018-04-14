package tdt4140.gr1801.app.core.pdfcreator;

import java.util.ArrayList;
import java.util.Arrays;
import com.itextpdf.text.Document;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.PersonalTrainer;


public class PdfTester {
	

    public static void main(String[] args) {
        try {
        	//
        	System.out.println("Creating Document...");
        	String filename = "Testfile";
            Document doc = PdfCreator.getNewDocument("/Users/kristoffergjerde/Desktop/" + filename + ".pdf");
            
            PersonalTrainer pt = new PersonalTrainer("kristogj", "Kristoffer", "Gjerde", "kristoffergjerde@gmail.com", "47503779", "13061997");
            Client client = new Client(0,"Klientnavn",180,pt);
            	
            PdfCreator.addMetaData(doc, "DocumentTitle", "Subject", new ArrayList<String>(Arrays.asList("key1","key2")), "Author", "Creator");
            PdfCreator.addFrontPage(doc, pt, client);
            PdfCreator.addContent(doc);
            doc.close();
            System.out.println("Document saved...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
