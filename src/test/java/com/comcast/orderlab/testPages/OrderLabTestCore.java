package com.comcast.orderlab.testPages;


import java.io.File;
import java.io.IOException;
import java.rmi.AccessException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.management.MBeanException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.comcast.orderlab.config.Configurations;
import com.comcast.orderlab.utility.CommonUtils;
import com.comcast.orderlab.utility.monitoringMail;



public class OrderLabTestCore {
	
	/*
	 * initializing properties, xls, creating db connection, 
	 * generating logs, initializing WebDriver
	 *  
	 */
	
	public static Properties config = new Properties();
	public static Properties object = new Properties();
	//public static ExcelReader excel = null;
	public static WebDriver driver = null;
	

	
	
	@BeforeSuite
	public  void init() throws IOException, InterruptedException
	{
		if (driver == null)
			
		{
			//loading config properties

		//	excel = new ExcelReader(Constants.TestSuiteDetailsSheetPath);
			
			if (Configurations.browser.equals("Chrome"))
			
			{
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if
			(Configurations.browser.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			else if
			(Configurations.browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
			
			driver.get(Configurations.TestSite);//Change the URL for Env
         //   WebDriverWait wait = new WebDriverWait(driver, 30L);


            //((WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Configurations.IhaveGotIt)))).click();
			

			
			
		}
		  
		
	}
	
	@AfterSuite
	public static void quitDriver() throws AccessException, MBeanException
	{
		//driver.quit();
		File source = new File(System.getProperty("user.dir")+"\\test-output\\"+"\\emailable-report.html");
		
		File dest = new File(System.getProperty("user.dir")+"\\TestReports"+"\\emailable-report.html");
		try {
		    FileUtils.copyFile(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		CommonUtils.zip(System.getProperty("user.dir")+"\\TestReports");
		monitoringMail mail = new monitoringMail();
		
		try {
			mail.sendMail(Configurations.server, Configurations.from, Configurations.to, Configurations.subject, Configurations.messageBody, Configurations.TestReportsPath, Configurations.TestReportsName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

