package com.wfs.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wfs.qa.base.*;
public class MyCartPage extends TestBase{

	@FindBy(xpath="//*[@class='android.widget.TextView'][@text='My Cart']")
	WebElement myCart;
	
	@FindBy(id="com.awfs.coordination:id/btnCloseCart")
	WebElement btnclose;
	
	public MyCartPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void myCart(){
		myCart.click();
	}
	
	
	public void btnclose(){
		btnclose.click();
	}
	
}
