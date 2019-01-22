package com.wfs.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.*;
public class BeautyPage extends TestBase {

	@FindBy(xpath="//*[@index='0'][@text='Gift Cards']")
	WebElement giftCards;
	
	@FindBy(xpath="//*[@text='Woolworths Gift Cards'][@index='0']")
	WebElement wGiftCards;
	
	public BeautyPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void giftCards(){
		giftCards.click();
	}
	
	public void wGiftCards(){
		wGiftCards.click();
	}
	
	
}
