package com.comcast.orderlab.utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name= "getDataSuite1")
	public static Object [][]getDataSuite1(Method m)
	{
		System.out.println(m.getName());
		ExcelReader excel = new ExcelReader(Constants.Suite1_TestDataPath);
		String TestCaseName = m.getName();
		return CommonUtils.getData(TestCaseName, excel);//Test Case Name
	}
	
	@DataProvider(name= "getDataSuite2")
	public static Object [][]getDataSuite2(Method m)
	{
		System.out.println(m.getName());
		ExcelReader excel = new ExcelReader(Constants.Suite2_TestDataPath);
		String TestCaseName = m.getName();
		return CommonUtils.getData(TestCaseName, excel);//Test Case Name
	}


}
