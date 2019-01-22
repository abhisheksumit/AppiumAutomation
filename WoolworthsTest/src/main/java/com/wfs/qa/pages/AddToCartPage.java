package com.wfs.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.*;
public class AddToCartPage extends TestBase {

	@FindBy(id="com.awfs.coordination:id/rlAddToCart")
	WebElement addToCart;
	
	@FindBy(xpath="//*[@index='0'][@text='1']")
	WebElement quantity;
	
	
	public AddToCartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart(){
		addToCart.click();
	}
	
	public void quantity(){
		quantity.click();
	}
}
