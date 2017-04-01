package com.comcast.orderlab.testPages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.orderlab.config.Configurations;



public class LoginPage   {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver; }

	
	@FindBy(xpath=Configurations.username)
	public WebElement username;
	
	@FindBy(xpath=Configurations.password)
	public WebElement password;
	
	@FindBy(xpath=Configurations.signin)
	public WebElement signin;
	
	@FindBy(xpath=Configurations.errorMsg)
	public WebElement errorMsg;
	


	
	public SearchAddress doLogin(String UserId, String Password) throws IOException
	{
		//WebDriverWait wait = new WebDriverWait(driver, 10000);
       
		
		username.sendKeys(UserId);
		password.sendKeys(Password);
		signin.click();
		return PageFactory.initElements(driver, SearchAddress.class);
		
		

	}
	
	public void loginFailed(String UserId, String Password, String ErrorMessage){
		username.sendKeys(UserId);
		password.sendKeys(Password);
		signin.click();
		String ErrorMsg = errorMsg.getText();
		System.out.println(ErrorMsg);
		Assert.assertEquals(ErrorMsg, ErrorMessage);
	}



}
