package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass

	public static void setUpBeforeClass() throws IOException {

		properties = new Properties();

		FileInputStream inStream = new FileInputStream("./resources/others.properties");

		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 

		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		driver.manage().deleteAllCookies();
		screenShot.captureScreenShot("Login Page");
	}

/*	@BeforeMethod
	public void setUp() throws Exception {
	
	}
	
	@BeforeSuite
	public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.get("baseUrl");
	}*/
	

	@Test(priority=1)
	//RTTC_011 test case
	public void validLoginTest() throws InterruptedException, AWTException {

		loginPOM.sendUserName("admin");

		loginPOM.sendPassword("admin@123");

		screenShot.captureScreenShot("After entering the Login credentials");

		loginPOM.clickLoginBtn();

		screenShot.captureScreenShot("Loggged in");
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=2)
	//RTTC_012
	public void validLoginTest1() throws InterruptedException, AWTException {

		loginPOM.sendUserName("admin");

		loginPOM.sendPassword("admin@123");

		screenShot.captureScreenShot("After entering the Login credentials");

		loginPOM.clickLoginBtn();

		screenShot.captureScreenShot("Loggged in");

		Thread.sleep(3000);

		loginPOM.clickCatalogName();

		screenShot.captureScreenShot("List of items in Catalog"); 

		loginPOM.clickCatagories();

		screenShot.captureScreenShot("List of items in Category"); 


	} 
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	
}