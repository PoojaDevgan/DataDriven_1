package com.ssl2.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ssl2.base.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		System.out.println("Inside Test");
		driver.findElement(By.xpath(OR.getProperty("bankManagerLogin_Xpath"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("addCustomer_CSS"))).click();
		Assert.fail("Failing");
		//navigation.click("before assert");
		//Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustomer_CSS"))));
		//navigation.click("after assert");
		//Thread.sleep(5000);
		//navigation.click("addCustomer_CSS");
		//System.out.println("click add cust");
	}
	
}
