package tdt4140.gr1801.app.core.pdfcreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import javafx.collections.FXCollections;
import junit.framework.TestCase;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.DayProgram;
import tdt4140.gr1801.app.core.Exercise;
import tdt4140.gr1801.app.core.PersonalTrainer;

public class PdfTest extends TestCase{
	
	@Before
	protected void setUp() throws DocumentException {
        Document doc = PdfCreator.getNewDocument(System.getProperty("user.dir") + "/test.pdf");
        PersonalTrainer pt = new PersonalTrainer("kristogj", "Kristoffer", "Gjerde", "kristoffergjerde@gmail.com", "47503779", "13061997");
        Client client = new Client(0,"Klientnavn",180,pt);
        	
        PdfCreator.addMetaData(doc, "DocumentTitle", "Subject", new ArrayList<String>(Arrays.asList("key1","key2")), "Author", "Creator");
        PdfCreator.addFrontPage(doc, pt, client);
        DayProgram prog = new DayProgram("Monday", 60, 0.0, 0.0, "Testtest", new ArrayList<Exercise>());
        PdfCreator.addContent(doc, FXCollections.observableArrayList (prog));
        doc.close();
	}
	public void testFileCreated() {
		File f = new File(System.getProperty("user.dir") + "/test.pdf");
		assertEquals(f.exists(), true);		
	}
	
	@After
	public void tearDown() throws IOException  {
		Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir") + "/test.pdf");
		Files.delete(path);	
	}
	
	

}
