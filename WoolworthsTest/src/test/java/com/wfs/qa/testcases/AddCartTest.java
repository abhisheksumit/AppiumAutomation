package com.wfs.qa.testcases;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.aspectj.apache.bcel.classfile.Method;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfs.qa.base.GenerateWordReport;
import com.wfs.qa.base.TestBase;

import com.wfs.qa.pages.*;

public class AddCartTest extends TestBase {

	ShopPage sp;
	BeautyPage bp;
	WGiftCardsPage wgp;
	AddToCartPage addTCart;
	MyCartPage mycart;
	
	
	/*@BeforeMethod
	public void handleTestMethodName(Method method){
		String testName = method.getName();
		TestBase.testName= testName;
	}*/
	public AddCartTest(){
		super();
		
	}
	
	/*@BeforeMethod
	public void setUpReport() throws Exception{
	XWPFDocument doc = new XWPFDocument();
	wr= new GenerateWordReport(doc, "TC02-Add Cart");
	//wr.addScreenshot();
	//GenerateWordReport(doc, "addCart");
	
	}*/
	
	@Test
	public void addCart(){
		//TestBase.testName= "addCart";
		sp= new ShopPage();
		sp.shop();
		scroll(0.8,0.1);
		scroll(0.8,0.1);
		scroll(0.8,0.1);
		sp.beauty();
		bp= new BeautyPage();
		scroll(0.8,0.1);
		scroll(0.8,0.1);
		bp.giftCards();
		bp.wGiftCards();
		wgp= new WGiftCardsPage();
		wgp.product();
		addTCart= new AddToCartPage();
		addTCart.addToCart();
		addTCart.quantity();
		
		mycart= new MyCartPage();
		mycart.myCart();
		mycart.btnclose();
		
		
		
		
		
		
	}
}
