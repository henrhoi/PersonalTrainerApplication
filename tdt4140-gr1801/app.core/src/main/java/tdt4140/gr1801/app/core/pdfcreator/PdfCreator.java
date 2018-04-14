package tdt4140.gr1801.app.core.pdfcreator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tdt4140.gr1801.app.core.Client;
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
    
    //This method should just write the Healthplan
    public static void addContent(Document document) throws DocumentException {
    	//Example
    	Anchor anchor = new Anchor("First Chapter", catFont);
        anchor.setName("First Chapter");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Hello"));

        subPara = new Paragraph("Subcategory 2", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Paragraph 1"));
        subCatPart.add(new Paragraph("Paragraph 2"));
        subCatPart.add(new Paragraph("Paragraph 3"));

        // add a list
        createList(subCatPart);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);

        // add a table
        createTable(subCatPart);

        // now add all this to the document
        document.add(catPart);

        // Next section
        anchor = new Anchor("Second Chapter", catFont);
        anchor.setName("Second Chapter");

        // Second parameter is the number of the chapter
        catPart = new Chapter(new Paragraph(anchor), 1);

        subPara = new Paragraph("Subcategory", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("This is a very important message"));

        // now add all this to the document
        document.add(catPart);
        
        //Example
    }

    public static void createTable(Section subCatPart) throws BadElementException {
    	///EXAMPLE///
        PdfPTable table = new PdfPTable(3);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);
     	///EXAMPLE///

    }

    private static void createList(Section subCatPart) {
    	///EXAMPLE///
    	com.itextpdf.text.List list = new com.itextpdf.text.List(true, false, 10);
        list.add(new ListItem("First point"));
        list.add(new ListItem("Second point"));
        list.add(new ListItem("Third point"));
        subCatPart.add(list);
        ///EXAMPLE///
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
