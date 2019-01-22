package com.wfs.qa.pages;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.*;
public class AccountPage extends TestBase{
	
	//Page factory-Repository
	@FindBy(xpath="//*[@index='0'][@text='Accounts']")
	
	WebElement accounts;
	
	@FindBy(xpath="//*[@index='0'][@text='Sign in']")
	WebElement signIn;
	
	@FindBy(id="com.awfs.coordination:id/signOutBtn")
	WebElement signOut;
	
	public AccountPage(){ 
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void account() throws InterruptedException, IOException, InvalidFormatException{
		
		
		accounts.click();
		Thread.sleep(3000);
		screenShot();
		
		
		wr.addExecutionSteps("Step: Click on Account", "Account page should display", "As Expected", "Passed");
		wr.addScreenshot();
		
	}
	
	public void signIn() throws InterruptedException, IOException, InvalidFormatException{
		signIn.click();
		Thread.sleep(5000);
		screenShot();
		wr.addExecutionSteps("Step: Click on Sign In", "Sign In page should display", "As Expected", "Passed");
		wr.addScreenshot();
	}
	
	public void register(){
		signIn.click();
	}
	
	public void signOut(){
		signOut.click();
	}
	
	
}
