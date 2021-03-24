package com.ssl2.utilities;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCaptureUtil {
	
	//public static WebDriver driver;

	public static void CaptureScreenshot(WebDriver driver) throws IOException
	{
		Date d = new Date();
		String timestampfile = d.toString().replace(":", "_").replace(" ", "_");
		
		File fileName = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileName, new File("./Screenshot/"+timestampfile+".jpg"));
		
				
	}
	

}
