package com.wfs.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.*;
public class SignInHomePage extends TestBase {
	
	@FindBy(xpath="//*[@index='0'][@text='Sign Out']")
	WebElement signOut;
	
	@FindBy(xpath="//*[@index='1'][@text='Sandesh Hundekar']")
	 WebElement userName;

	public SignInHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void signOut(){
		signOut.click();
	}
	
	public  void validateUserName(){
		
		userName.getText();
	}
	
	
}
