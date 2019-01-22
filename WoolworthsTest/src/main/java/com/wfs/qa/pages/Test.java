package com.wfs.qa.pages;

import org.openqa.selenium.By;

import com.wfs.qa.base.TestBase;

public class Test extends TestBase {
	
	//objects-
	public String accounts="//*[@index='0'][@text='Accounts']";
	
	public String signIn="//*[@index='0'][@text='Sign in']";
	
	public String signOut="com.awfs.coordination:id/signOutBtn";
	
	
	public void accounts(){
		driver.findElementByXPath(accounts).click();
	}
	
	

}
