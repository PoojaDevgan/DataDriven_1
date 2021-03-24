package com.ssl2.rough;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ssl2.base.TestBase;



public class CommonUtil extends TestBase {
	
	public static String ScreenshotPath;
	public static String ScreenshotName;
	public static String timestamp;

	public static void captureScreenshot1() throws IOException {
		Date d = new Date();
		timestamp = d.toString().replace(":", "_").replace(" ", "_");	
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		ScreenshotName = "error_"+timestamp+".jpg";
		//FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"target\\surefire-reports\\html\\ScreenshotName"+timestamp+".jpg"));
		System.out.println(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\ScreenshotName");
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+ScreenshotName));
	
	}
	
	

}
