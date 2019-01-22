package com.wfs.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.wfs.qa.util.BaseObject;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestBase  {
	public static AndroidDriver driver;
	public static Properties prop;
	public static  String testName;
	public static GenerateWordReport wr;
	
	//public static FileOutputStream out;
	
	
	
	
	public TestBase(){
	try{
				prop= new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\sandesh.hundekar\\Documents\\PracticeProject\\WoolworthsTest"
						+"\\src\\main\\java\\com\\wfs\\qa\\config\\config.properties");
				prop.load(ip);
				
				//XWPFDocument doc = new XWPFDocument();
				//GenerateWordReport wr= new GenerateWordReport(doc, testName);
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	public static void initialization() throws MalformedURLException{
		
		
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platforName", "ANDROID");
		capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("appPackage", "com.awfs.coordination");
		capabilities.setCapability("appActivity",
				"za.co.woolworths.financial.services.android.ui.activities.StartupActivity");
		
		driver = new AndroidDriver(new URL(prop.getProperty("url")), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void scroll(double touchPoint, double scrollPoint){
		Dimension dimension = driver.manage().window().getSize();
		Double scrollHeightStart = dimension.getHeight() * touchPoint;//0.8
		int scrollStart = scrollHeightStart.intValue();

		Double scrollHeightEnd = dimension.getHeight() * scrollPoint;//0.1
		int scrollEnd = scrollHeightEnd.intValue();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(0, scrollEnd)).release().perform();
		
	}
	
	public static File screenShot() throws IOException{
		File scrFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File screenShotName = new File(/*prop.getProperty(*/"C:\\Users\\sandesh.hundekar\\Documents\\PracticeProject\\WoolworthsTest\\screenshots\\" + timeStamp + ".png");
		FileUtils.copyFile(scrFile, screenShotName);
		return screenShotName;
	}
	
	@BeforeSuite
	public void setUpReport() throws Exception{
	XWPFDocument doc = new XWPFDocument();
	wr= new GenerateWordReport(doc, "TC01-Verifying the functionality of Sign In");
	
	}
	
	
	
	
}
