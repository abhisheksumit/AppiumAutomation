package com.wfs.qa.testcases;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfs.qa.base.*;
import com.wfs.qa.pages.*;
import com.wfs.qa.util.ApplicationPopUp;
public class LogOutTest extends TestBase{
	
	AccountPage acc;
	ApplicationPopUp popUp;
	public LogOutTest(){
		super();
	}
	/*@BeforeMethod
	public void setUpReport() throws Exception{
	XWPFDocument doc = new XWPFDocument();
	wr= new GenerateWordReport(doc, "TC03-Sign Out");
	}*/
	
	@Test
	public void logOut() throws IOException, InvalidFormatException, InterruptedException{
		  
		acc=  new AccountPage();
		acc.account();
		
		scroll(0.8,0.1);
		scroll(0.8,0.1);
	
		acc.signOut();
		popUp= new ApplicationPopUp();
		popUp.logoutPopUp();
		
		wr.docEnd();//To close the document report
	}
	
}
