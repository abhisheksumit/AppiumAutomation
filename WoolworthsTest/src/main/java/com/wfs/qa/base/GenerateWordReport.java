package com.wfs.qa.base;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class GenerateWordReport {

	 
	private  XWPFDocument document;
	private FileOutputStream out;
	
	public GenerateWordReport(XWPFDocument document, String testName) throws IOException, Exception {
		
		this.document = document;
		
		
		String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		setupPageFormat();
		out = new FileOutputStream(new File("C:\\Users\\sandesh.hundekar\\Documents\\PracticeProject\\WoolworthsTest\\reports\\" + testName + "_" + timeStamp + ".docx"));
		
		//Page Setup
		//setupPageFormat();
		//Create Output stream 
		
		//Create the paragraph
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();

		//Create the header table with 3 rows and 5 columns
		XWPFTable headerTable = run.getDocument().createTable(3, 5);
		//Set the table layout
		CTTblLayoutType type = headerTable.getCTTbl().getTblPr().addNewTblLayout();
		type.setType(STTblLayoutType.FIXED);
		//Merge the row 1 column from 2 to 5
		mergeCellsHorizontally(headerTable, 0, 1, 4);
		//Merrge the row 1 and row 2 of column 1
		mergeCellsVertically(headerTable, 0, 0, 1);
		//Create the object for the first row of header table
		XWPFTableRow rowOne = headerTable.getRow(0);
		//Set the background color and text of the cell
		setFontAndText(rowOne, 0, "Test Case");
		setFontAndText(rowOne, 1, "Execution History");
		setFontAndText(rowOne, 2, "");
		setFontAndText(rowOne, 3, "");
		setFontAndText(rowOne, 4, "");
		//Enter the text in row 2
		XWPFTableRow rowTwo = headerTable.getRow(1);
		setFontAndText(rowTwo, 0, "");
		setFontAndText(rowTwo, 1, "Start Date");
		setFontAndText(rowTwo, 2, "Start Time");
		setFontAndText(rowTwo, 3, "End Time");
		setFontAndText(rowTwo, 4, "Status");
		//Enter the text in row 3
		XWPFTableRow rowThree = headerTable.getRow(2);
		setTextAndSize(rowThree, 0, true, ParagraphAlignment.LEFT, testName, 5200);
		setTextAndSize(rowThree, 1 ,true, ParagraphAlignment.CENTER, getCurrentDate(),1400);
		setTextAndSize(rowThree, 2,true, ParagraphAlignment.CENTER, getCurrentTime(), 1400);
		setTextAndSize(rowThree, 3,true, ParagraphAlignment.CENTER, getCurrentTime(), 1400);
		addColorForStatus(rowThree, 4, "Passed", 1400);
		//document.write(out);
		//this.document.write(out);
	}
	
	@SuppressWarnings("deprecation")
	public void setTextAndSize(XWPFTableRow row, int pos, boolean bold, ParagraphAlignment align,  String text, int size) {
		
		XWPFRun run;
		//Set the text value in the cell
		run = row.getCell(pos).addParagraph().createRun();
		run.setText(text);
		run.setBold(bold);
		run.getParagraph().setAlignment(align);
		//Resize the cell
		row.getCell(pos).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(size));
		
	}
	
	public void setupPageFormat() {
		//Add Margin to the page 1 inch for top and buttom and 0.5 inch for right and left
		CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
	    CTPageMar pageMar = sectPr.addNewPgMar();
	    pageMar.setLeft(BigInteger.valueOf(720L));
	    pageMar.setTop(BigInteger.valueOf(1440L));
	    pageMar.setRight(BigInteger.valueOf(720L));
	    pageMar.setBottom(BigInteger.valueOf(1440L));
	}
	
	public void addColorForStatus(XWPFTableRow row, int cell, String status, int size) {
		XWPFRun run = row.getCell(cell).addParagraph().createRun();
		run.setText(status);
		run.setBold(true);
		run.getParagraph().setAlignment(ParagraphAlignment.CENTER);
		row.getCell(cell).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(size));
		if (status == "Passed") {
			run.setColor("27AB13");
		} else {
			run.setColor("F50E0E");
		}
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void setFontAndText(XWPFTableRow row, int pos, String text) {
		XWPFRun run;
		row.getCell(pos).setColor("6C6464");
		run = row.getCell(pos).addParagraph().createRun();
		run.setColor("FFFFFF");
		run.setBold(true);
		run.setFontSize(10);
		run.setText(text);
		run.getParagraph().setAlignment(ParagraphAlignment.CENTER);
		row.getCell(pos).setVerticalAlignment(XWPFVertAlign.CENTER);
		
	}
	
	private static void mergeCellsHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
			   for (int cellIndex = fromCol; cellIndex <= toCol; cellIndex++) {
			      XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
			      if (cellIndex == fromCol) {
			        cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
			      } else {
			        cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
			      }
			  }
			 }

	private static void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {
			   for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
			      XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
			      if (rowIndex == fromRow) {
			        cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
			      } else {
			        cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
			      }
			   }
	}
	
	public void addScreenshot() throws IOException, InvalidFormatException {
		
		File image = TestBase.screenShot();
		XWPFParagraph imagePara = document.createParagraph();
		imagePara.setAlignment(ParagraphAlignment.CENTER);
		
		XWPFRun imageRun = imagePara.createRun();
		//Add Line Break
		imageRun.addBreak();
		//Add Image 
		imageRun.addPicture(new FileInputStream(image), XWPFDocument.PICTURE_TYPE_PNG, image.toString(), Units.toEMU(250), Units.toEMU(360));
		imageRun.addBreak();
		//document.write(out);
	}
	
	public String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		return currentDate;	
	}
	
	public String getCurrentTime() {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String currentTime = timeFormat.format(now);
		return currentTime;
		
	}
	
	public void addExecutionSteps(String strDescription, String strExpectedResult, String strActualResult, String strStatus) throws IOException, InvalidFormatException {
		
		XWPFParagraph p = document.createParagraph();
		XWPFRun r = p.createRun();
		XWPFTable stepTable = r.getDocument().createTable(2, 4);
		//Create the object for the first row of header table
		XWPFTableRow rowOne = stepTable.getRow(0);
		//Set the background color and font size of the header table
		setFontAndText(rowOne, 0, "Step Description");
		setFontAndText(rowOne, 1, "Expected Result");
		setFontAndText(rowOne, 2, "Actual Result");
		setFontAndText(rowOne, 3, "Status");	
		
		XWPFTableRow rowTwo = stepTable.getRow(1);
		setTextAndSize(rowTwo, 0, false, ParagraphAlignment.LEFT, strDescription, 4000);
		setTextAndSize(rowTwo, 1, false, ParagraphAlignment.LEFT, strExpectedResult, 3000);
		setTextAndSize(rowTwo, 2, false, ParagraphAlignment.LEFT, strActualResult, 3000);
		addColorForStatus(rowTwo, 3, strStatus, 1000);
		//Add screenshot for the test steps
		//this.addScreenshot();
		//document.write(stream);
		//this.document.write(out);
		
	}
	
	
	
	
	public void docEnd() throws IOException{
		this.document.write(out);
	}
	

}
