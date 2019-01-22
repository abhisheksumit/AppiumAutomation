package com.wfs.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.*;
public class WGiftCardsPage extends TestBase{

	//@FindBy(xpath="//*[@index='1'][@text='R 200.00']")
	@FindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.awfs.coordination:id/textAmount')]")
	WebElement product;
	
	public WGiftCardsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void product(){
		product.click();
	}
}
