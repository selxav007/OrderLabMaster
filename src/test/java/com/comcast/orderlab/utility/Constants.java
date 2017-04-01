package com.comcast.orderlab.utility;

public class Constants {

	public static final String Suite1_TestDataPath = System.getProperty("user.dir")+"\\src\\test\\resources\\data\\Suite1_TestDataSheet.xlsx";

	public static final String Suite2_TestDataPath = System.getProperty("user.dir")+"\\src\\test\\resources\\data\\Suite2_TestDataSheet.xlsx";

	public static final String TestSuiteDetailsSheetPath = System.getProperty("user.dir")+"\\src\\test\\resources\\data\\TestSuiteDetails.xlsx";

	public static final String SuiteSheetName = "TestSuite";//SheetName of testSuite Xls

	public static final String TestSuiteCol_SuiteName = "SuiteName";
	
	public static final String TestSuiteCol_RunMode = "RunMode";

	public static final String SuiteRunModeValue = "Y";

	public static final String TestCaseSheetName = "TestCases";//Change the name as per the sheet name of test data sheet

	public static final String TestCaseCol_TestCaseName = "TCID";//Should be same as the column name from the data sheet

	public static final String TestCaseCol_RunMode = "RunMode";//Should be same as the column name from the data sheet
	
	public static final String TestCaseRunModeValue = "Y";
}
 