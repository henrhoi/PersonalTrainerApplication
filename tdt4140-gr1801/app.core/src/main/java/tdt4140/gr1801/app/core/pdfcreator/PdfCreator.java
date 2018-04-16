package tdt4140.gr1801.app.core.pdfcreator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.collections.ObservableList;
import tdt4140.gr1801.app.core.Client;
import tdt4140.gr1801.app.core.DayProgram;
import tdt4140.gr1801.app.core.Exercise;
import tdt4140.gr1801.app.core.PersonalTrainer;

//http://www.vogella.com/tutorials/JavaPDF/article.html

public class PdfCreator {
	
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
    
    //Make a new document
    public static Document getNewDocument(String filepath) {
    	Document document = new Document();
        try {
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
		} catch (FileNotFoundException | DocumentException e) {
			System.out.println(e.getMessage());
		}
        document.open();
        return document;
    }
    
    //Add metadata to the document
    public static void addMetaData(Document document, String title, String subject, List<String> keywords, String author, String creator) {
        document.addTitle(title);
        document.addSubject(subject);
        document.addKeywords(String.join(", ", keywords));
        document.addAuthor(author);
        document.addCreator(creator);
    } 
    
    //Add front page
    public static void addFrontPage(Document document, PersonalTrainer pt, Client client) throws DocumentException {
        Paragraph preface = new Paragraph();
        
        //Write content
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("TraningProgram", catFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Program made by " + pt.getName() + ", " + new Date(), smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("This document contains a personal training program for " + client.getName(), smallBold));
        addEmptyLine(preface, 8);
        
        //Add paragraph to document, and make a new page
        document.add(preface);
        document.newPage();
    }
    
    //Add content to the TrainingProgram
    public static void addContent(Document document, ObservableList<DayProgram> programs) throws DocumentException {
    	Paragraph content = new Paragraph();
    	for (DayProgram program : programs) {
    		addEmptyLine(content, 1);
    		content.add(new Paragraph(program.getWeekday(), catFont));
    		//Strength Program
    		if(program.getExercises() != null) {
    			//Make a table with all the exercises and add to doc
    			PdfPTable table = createTable(program.getExercises());
    			content.add(table);
    		}
    		//Endurance Program
    		if(program.getAvgSpeed() != null) {
    			//Add all the fields given in an Endurance object
    			Paragraph subpar = new Paragraph();
    			subpar.add(new Paragraph("Distance: " + program.getDistance() + "km"));
    			subpar.add(new Paragraph("Duration: " + program.getDuration()));
    			subpar.add(new Paragraph("Avg.speed: " + program.getAvgSpeed()));
    			subpar.add(new Paragraph("Description: " + program.getDescription()));
    			content.add(subpar);
    		}
    	}
    	//Add content to document
    	document.add(content);
    }
    
    //Create a Table for Strength Exercises
    private static PdfPTable createTable(List<Exercise> exs) throws DocumentException {
    	//A table with four columns
        PdfPTable table = new PdfPTable(4);
        //Headers
        addTextToNextTableCell("Name", table);
        addTextToNextTableCell("Weight", table);
        addTextToNextTableCell("Sets", table);
        addTextToNextTableCell("Repetitions", table);
        //Add Exercises
        for (Exercise ex : exs) {
        	addTextToNextTableCell(ex.getName(), table);
        	addTextToNextTableCell(ex.getWeight()+"", table);
        	addTextToNextTableCell(ex.getNumberOfSets()+"", table);
        	addTextToNextTableCell(ex.getReps(), table);
        }
        //Add Table to document
        return table;
    }
    
    private static void addTextToNextTableCell(String str, PdfPTable table) {
   	 PdfPCell cell = new PdfPCell(new Paragraph(str));
        table.addCell(cell);
   }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
