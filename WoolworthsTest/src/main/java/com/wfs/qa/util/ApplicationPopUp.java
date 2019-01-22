package com.wfs.qa.util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.*;
public class ApplicationPopUp extends TestBase {
	
	@FindBy(id="com.awfs.coordination:id/close")
	WebElement loginPopUp;
	
	@FindBy(id="com.awfs.coordination:id/btnSignOut")
	WebElement logoutPopUp;
	
	public ApplicationPopUp(){ 
		PageFactory.initElements(driver, this);
	}
	
	
	public  void loginPopUp(){
		loginPopUp.click();
	}
	
	public void logoutPopUp(){
		logoutPopUp.click();
	}
	
	
}
