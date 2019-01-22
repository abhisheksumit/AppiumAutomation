package com.wfs.qa.pages;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.TestBase;
import com.wfs.qa.util.Utils;


public class SignInPage extends TestBase{

	//Page Factory--OR
	
	@FindBy(xpath="//*[@index='0'][@class='android.widget.EditText']")
	 WebElement username;
	
	@FindBy(xpath="//*[@index='2'][@class='android.widget.EditText']")
	
	WebElement password;
		
	@FindBy(xpath="//*[@index='3'][@class='android.widget.Button']")
	WebElement signbtn;	
	
	public SignInPage(){ 
		PageFactory.initElements(driver, this);
	}
		
		
	public  void signIn() throws IOException, InvalidFormatException, InterruptedException{
		
		Utils utils=new Utils();
		utils.setCredentials();
		String userName=Utils.getUserName();
	    String passWord=Utils.getPassword();
	    
	    
		username.sendKeys(userName);
		password.sendKeys(passWord);
		Thread.sleep(3000);
		//wr.addExecutionSteps(strDescription, strExpectedResult, strActualResult, strStatus);
		screenShot();
		wr.addExecutionSteps("Step: Enter the valid userName and valid password in the respective fields", "Username and passowrd field should accept the values", "As Expected", "Passed");
		wr.addScreenshot();
		
		signbtn.click();
		Thread.sleep(5000);
		screenShot();
		wr.addExecutionSteps("Step: Click on Sign In button to login into account", "User should be loged in successfully and user account home page should be display", "As Expected", "Passed");
		wr.addScreenshot();
		
	}
	
	
}
