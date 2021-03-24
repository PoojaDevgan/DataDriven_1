package com.ssl2.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ssl2.base.TestBase;
import com.ssl2.utilities.DataProviderUtil;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
	public void TestData(String firstName, String lastName, String postCode) throws IOException, InterruptedException
	{
		System.out.println("Inside Add Customer");
		
		//driver.findElement(By.cssSelector(OR.getProperty("addCustomer_CSS"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstName_Xpath"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastName_Xpath"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("postCode_Xpath"))).sendKeys(postCode);
		driver.findElement(By.xpath(OR.getProperty("addCustomerBttn_Xpath"))).click();
		
		//navigation.type("firstName_Xpath", firstName);
		//navigation.type("lastName_Xpath", lastName);
		//Thread.sleep(5000);
		//navigation.type("postCode_Xpath", postCode);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")));
		//navigation.click("addCustomerBttn_Xpath");
		
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Customer Added Successfully");
		Reporter.log("<br>");
		Reporter.log("<a target=\"blank\" href = \"C:\\Users\\pooja-devgan\\Pictures\\error.jpg\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"blank\" href = \"C:\\Users\\pooja-devgan\\Pictures\\error.jpg\"><img src=\"C:\\Users\\pooja-devgan\\Pictures\\error.jpg\" height = 30 width = 30></img></a>");
		
		/*navigation.click("addCustomer_CSS");
		navigation.type("firstName_Xpath", firstName);
		navigation.type("lastName_Xpath", lastName);
		navigation.type("postCode_Xpath", postCode);
		navigation.click("addCustomerBttn_Xpath");*/
	}

}
