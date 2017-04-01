package com.comcast.orderlab.utility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.SkipException;

public class CommonUtils extends com.comcast.orderlab.testPages.OrderLabTestCore{
	public 	static boolean isTestCaseExecutable(String testCaseName, ExcelReader excel)
	{
		
		
		String testCaseSheetName = Constants.TestCaseSheetName;
		int rows= excel.getRowCount(testCaseSheetName);
		
		
		for(int rowNum=2;rowNum<=rows; rowNum++)
		{
			
			String TestCaseName= excel.getCellData(testCaseSheetName, Constants.TestCaseCol_TestCaseName, rowNum);
			if (TestCaseName.equalsIgnoreCase(testCaseName))
			{
				String RunMode = excel.getCellData(testCaseSheetName, Constants.TestCaseCol_RunMode, rowNum);
				 if (RunMode.equalsIgnoreCase(Constants.TestCaseRunModeValue))
				 {
					 return true;
				 } 
				 
				 else
				 {
					 return false;
				 }
				 
			}
			
		}
		return false;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public 	static boolean isSuiteExecutable(String SuiteName)
	{
		
		ExcelReader excel = new ExcelReader(Constants.TestSuiteDetailsSheetPath);
		
		String suiteSheetName = Constants.SuiteSheetName;
		int rows= excel.getRowCount(suiteSheetName);
		
		for(int rowNum=2;rowNum<=rows; rowNum++)
		{
			
			String TestSuiteName= excel.getCellData(suiteSheetName, Constants.TestSuiteCol_SuiteName, rowNum);
			if (TestSuiteName.equalsIgnoreCase(SuiteName))
			{
				String RunMode = excel.getCellData(suiteSheetName, Constants.TestSuiteCol_RunMode, rowNum);
				 if (RunMode.equalsIgnoreCase(Constants.SuiteRunModeValue))
				 {
					 return true;
				 }
				 
				 else
				 {
					 return false;
				 }
				 
			}
			
		}
		return false;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void checkExecution(		
			String testSuiteName,
			String testCaseName,
			String dataRunmode,
			ExcelReader excel)
	
		{

		if (!isSuiteExecutable(testSuiteName))
			{
			throw new SkipException("Skipping the Test Case "+testCaseName+ " as the RunMode of the Test Suite "+ testSuiteName + " is No." );
			}
		
		if (!isTestCaseExecutable(testCaseName, excel))
			{
			throw new SkipException("Skipping the Test Case "+testCaseName+ " as the RunMode of the testCaseName "+ testCaseName + " is No." );
			}
		
		if (dataRunmode.equalsIgnoreCase("N"))
			{
			throw new SkipException("Skipping the Test Case "+testCaseName+ " as the RunMode of the test data "+  " is No." );
			}
		
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	//get the test Data
	public static Object[][] getData(String TestCase, ExcelReader excel){
	
	String SheetName = "TestData"; //Same as the Sheet Name of the where we add test data details
	
	String TestCaseName = TestCase;
	
	//Test Case Start from 1
	int testCaseRowNum= 1;
	
	while(!excel.getCellData(SheetName, 0, testCaseRowNum).equalsIgnoreCase(TestCaseName))
	{
	testCaseRowNum++;
	}
	System.out.println("test case Start from "+testCaseRowNum);
	
	//Find Total Cols and Rows- Cols Start from and test data Start From
	
	int colStartRowNum= testCaseRowNum+1;
	
	int dataStartRowNum= colStartRowNum+1;
	
	//Total Cols in Test Are
	
	int cols = 0;
	
	while(!excel.getCellData(SheetName, cols, colStartRowNum).trim().equals(""))
	{
		cols++;
	}
	System.out.println("Total Cols in Test Case is "+cols);
	
	
	//Total Rows in Test Are
	int rows = 0;
	
	while(!excel.getCellData(SheetName, 0, dataStartRowNum+rows).trim().equals(""))
	{
		rows++;
	}
	System.out.println("Total Rows in Test Case is "+rows);
	
	//Printing the test Data
	
	Object[][] data = new Object[rows][1];
	
	int i =0;
	for(int row=dataStartRowNum;row<dataStartRowNum+rows;row++)
	{
		Hashtable<String,String> table = new Hashtable<String,String>();
		for (int col=0;col<cols;col++)
		
		{
		
		//System.out.println(excel.getCellData(SheetName, col, row));
		
		//data[row-dataStartRowNum][col] =excel.getCellData(SheetName, col, row);
		String Testdata =excel.getCellData(SheetName, col, row);
		String colName =excel.getCellData(SheetName, col, colStartRowNum);
		table.put(colName, Testdata);
		}
		
		data [i][0] = table;
		i++;
	}
	
	return data;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void captureScreenshot(String ScreenShot)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./TestReports/"+ScreenShot+".jpeg"));
		} catch (Exception e) 
		{
			System.out.println("Exception in printing"+e.getMessage());
		} 
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static  boolean setData(String sheetName, String colName,  String data){
		ExcelReader excel = new ExcelReader(Constants.TestSuiteDetailsSheetPath);
	int rows = excel.getRowCount(sheetName);

	for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ 
		
		String colVal= excel.GetCellValue(sheetName, colName, rowNum);
		 
		if(colVal=="")
		{
			excel.setCellData(sheetName, colName, rowNum, data);
			break;
		}
		
		
	}
	return false;
	}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String mailscreenshotpath;
		public static void captureScreen(String methodName) throws IOException{
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	    	mailscreenshotpath = System.getProperty("user.dir")+"\\TestReports\\"+methodName+"_"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
			FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
				
		}
	    
	    }
		
		// make zip of reports
		public static void zip(String filepath){
		 	try
		 	{
		 		File inFolder=new File(filepath);
		 		File outFolder=new File("TestReports.zip");
		 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
		 		BufferedInputStream in = null;
		 		byte[] data  = new byte[1000];
		 		String files[] = inFolder.list();
		 		for (int i=0; i<files.length; i++)
		 		{
		 			in = new BufferedInputStream(new FileInputStream
		 			(inFolder.getPath() + "/" + files[i]), 1000);  
		 			out.putNextEntry(new ZipEntry(files[i])); 
		 			int count;
		 			while((count = in.read(data,0,1000)) != -1)
		 			{
		 				out.write(data, 0, count);
		 			}
		 			out.closeEntry();
	  }
	  out.flush();
	  out.close();
		 	
	}
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  } 
	 }

}
