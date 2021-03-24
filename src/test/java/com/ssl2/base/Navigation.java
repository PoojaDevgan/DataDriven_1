package com.ssl2.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;


public class Navigation {
	
	public void click(String locator)
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
	}

	public void type(String locator, String value) throws IOException
	{
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
	
	public WebElement findElement(String locator)
	{
		
		try
		{
		if(locator.endsWith("_Xpath"))
		{
			TestBase.element = TestBase.driver.findElement(By.xpath(TestBase.OR.getProperty(locator)));
			 
		}
		else if(locator.endsWith("_Id"))
		{
			TestBase.element = TestBase.driver.findElement(By.id(TestBase.OR.getProperty(locator)));
			
		}
		else if(locator.endsWith("_CSS"))
		{
			TestBase.element = TestBase.driver.findElement(By.cssSelector(TestBase.OR.getProperty(locator)));
		}
		}
		catch(Throwable t)
		{
			System.out.println("Unable to find element: "+t.getMessage());
		}
		return TestBase.element;
	}


}
