package com.wfs.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfs.qa.base.GenerateWordReport;
import com.wfs.qa.base.TestBase;
import com.wfs.qa.pages.SignInPage;
import com.wfs.qa.util.ApplicationPopUp;
import com.wfs.qa.pages.AccountPage;
import com.wfs.qa.pages.HomePage;

public class SignInPageTest extends TestBase {
	
	HomePage hp;
	AccountPage acc;
	SignInPage sInPage;
	ApplicationPopUp popUp;
	public SignInPageTest(){
		super();
	}
	
	/*@BeforeMethod
	public void setUpReport() throws Exception{
	XWPFDocument doc = new XWPFDocument();
	wr= new GenerateWordReport(doc, "TC01-Sign In");
	}*/
	
  @Test
  public  void signIn() throws IOException, InvalidFormatException, InterruptedException  {
    
  initialization();
  
 
  hp= new HomePage();
  hp.skip();
  
  acc=  new AccountPage();
  acc.account();
  acc.signIn();
  
  sInPage= new SignInPage();
  sInPage.signIn();
  
  popUp= new ApplicationPopUp();
  popUp.loginPopUp();
  
 
  

 
  
  
  

}
}
