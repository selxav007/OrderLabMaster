package com.comcast.orderlab.testSuite1;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.orderlab.testPages.LoginPage;
import com.comcast.orderlab.testPages.OrderLabTestCore;
import com.comcast.orderlab.utility.CommonUtils;
import com.comcast.orderlab.utility.Constants;
import com.comcast.orderlab.utility.DataProviders;
import com.comcast.orderlab.utility.ExcelReader;

public class LoginWithValidCredentials extends OrderLabTestCore{
	


	@Test(dataProviderClass=DataProviders.class,dataProvider= "getDataSuite1")//Change the Suite Name from Data Provider
	public void loginWithValidCredentials(Hashtable<String,String> data) throws IOException
	{
		ExcelReader excel = new ExcelReader(Constants.Suite1_TestDataPath);
		CommonUtils.checkExecution("Suite1", "LoginWithValidCredentials", data.get("RunMode"), excel);
		LoginPage loginOrderlab = PageFactory.initElements(driver, LoginPage.class);
		loginOrderlab.doLogin(data.get("UserId"),data.get("Password"));
		//driver.close();
	}

}
