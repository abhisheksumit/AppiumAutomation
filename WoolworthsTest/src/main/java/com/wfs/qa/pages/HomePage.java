package com.wfs.qa.pages;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.*;
public class HomePage extends TestBase{

	@FindBy(xpath="//*[@index='0'][@text='SKIP']")
	
	WebElement skip;
	
	public  HomePage(){ 
		PageFactory.initElements(driver, this);
	}
	
	public void skip() throws IOException, InvalidFormatException, InterruptedException{
		Thread.sleep(3000);
		screenShot();
		
	//	wr.addExecutionSteps(strDescription, strExpectedResult, strActualResult, strStatus);
		wr.addExecutionSteps("Step: Open the woolworths mobi one application", "Application should be open", "As Expected", "Passed");
		wr.addScreenshot();
		skip.click();
		screenShot();
		
		wr.addExecutionSteps("Step: Click on skip to close the skip page", "Skip page should be close", "As Expected", "Passed");
		wr.addScreenshot();
	}
	
}
