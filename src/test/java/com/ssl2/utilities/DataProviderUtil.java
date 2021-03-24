package com.ssl2.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ssl2.base.TestBase;


public class DataProviderUtil extends TestBase {

	@DataProvider(name="dp",parallel=false)
	public static Object[][] TestData(Method m)
	{

		//ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\Excel\\TestData.xlsx");
		String sheetName = m.getName();
		System.out.println(sheetName);
		int rownum = excel.getRowCount(sheetName);
		int colnum = excel.getColumnCount(sheetName);
		
		Object[][] obj = new Object[rownum-1][colnum];
		
		for(int rows=2; rows<=rownum; rows++)
		{
			for(int cols=0; cols<colnum; cols++)
			{
				obj[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
	
		return obj;

	}

}
