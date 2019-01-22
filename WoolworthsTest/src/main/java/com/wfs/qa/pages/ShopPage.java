package com.wfs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.TestBase;

public class ShopPage extends TestBase {

	@FindBy(xpath="//*[@index='1'][@class='android.widget.FrameLayout']")
	WebElement shop;
	
	@FindBy(xpath="//*[@index='1'][@text='Beauty']")
	WebElement beauty;
	
	public ShopPage(){ 
		PageFactory.initElements(driver, this);
	}
	
	public void shop(){
		shop.click();
	}
	
	public void beauty(){
	   beauty.click();	
	}
	
}
