package com.ssl2.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ssl2.utilities.ExcelReader;
import com.ssl2.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger(TestBase.class.getSimpleName());
	public static Properties OR = new Properties();
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\Excel\\TestData.xlsx");
	public static Properties config = new Properties();
	public static Navigation navigation;
	public static WebElement element;
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setup()
	{
		if (driver == null) {
	
			PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");

			try {
				fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
				config.load(fis);
				log.info("Successfully Loaded config property file");
			} catch (IOException e) {
				System.out.println("Unable to load Config properties");
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
				OR.load(fis);
				log.info("Successfully Loaded OR property file");
			} catch (IOException e) {
				System.out.println("Unable to load OR properties");
				e.printStackTrace();
			}

			System.out.println(config.getProperty("browser"));
			if (config.getProperty("browser").equals("chrome")) {
				System.out.println("Inside chrome");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.info("Chrome driver successfully setup");
				
			} else if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox driver successfully setup");
			} else if (config.getProperty("browser").equals("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				log.info("IE driver successfully setup");
			} else {
				System.out.println("Wrong browser Info! Please correct!!");
				log.info("Wrong browser Info!");
			}

		}
		
		navigation = new Navigation();
		
		System.out.println("After chrome driver setup --> Maximize");
		driver.manage().window().maximize();
		
		driver.get(config.getProperty("testSiteUrl"));
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.Wait")),TimeUnit.SECONDS);
	
	}


	/*
	public static void click(String locator)
	{
		try
		{
		if(locator.endsWith("_Xpath"))
		{
			TestBase.driver.findElement(By.xpath(TestBase.OR.getProperty(locator))).click();
			TestBase.test.log(LogStatus.INFO, "Clicking on: "+locator);
		}
		else if(locator.endsWith("_Id"))
		{
			TestBase.driver.findElement(By.id(TestBase.OR.getProperty(locator))).click();
			TestBase.test.log(LogStatus.INFO, "Clicking on: "+locator);
		}
		else if(locator.endsWith("_CSS"))
		{
			TestBase.driver.findElement(By.cssSelector(TestBase.OR.getProperty(locator))).click();
			TestBase.test.log(LogStatus.INFO, "Clicking on: "+locator);
		}
		}
		catch(Throwable t)
		{
			System.out.println("Unable to find element: "+t.getMessage());
		}
	}*/

	
	
	
	//@AfterSuite
	public void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
	
	public boolean isElementPresent(By by)
	{
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {

			return false;
		}
	}


	/*

	public static void type(String locator, String value) {
		try
		{
		if(locator.endsWith("_Id"))
		{
		TestBase.driver.findElement(By.id(TestBase.OR.getProperty(locator))).sendKeys(TestBase.OR.getProperty(value));
		TestBase.test.log(LogStatus.INFO, "Typing on: "+locator);
		}else if(locator.endsWith("_Xpath"))
		{
		TestBase.driver.findElement(By.xpath(TestBase.OR.getProperty(locator))).sendKeys(TestBase.OR.getProperty(value));
		TestBase.test.log(LogStatus.INFO, "Typing on: "+locator);
		}
		else if(locator.endsWith("_CSS"))
		{
		TestBase.driver.findElement(By.cssSelector(TestBase.OR.getProperty(locator))).sendKeys(TestBase.OR.getProperty(value));
		TestBase.test.log(LogStatus.INFO, "Typing on: "+locator);
		}
		
		TestBase.log.info("Text has been Entered Sucessfully fOR "+locator);
		
		}catch(Throwable t)
		{
			TestBase.log.info("ErrOR while locating element: "+locator+"\n ErrOR Message is: "+t.getMessage());
		}
		
	}
	*/
	/*public static void main(String[] args) throws FileNotFoundException {
		TestBase obj = new TestBase();
	}*/
}
