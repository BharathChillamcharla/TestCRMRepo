package com.crm.qa.testcases;

import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	Logger log=Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() throws IOException {
		
		super();
		
	}

	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		
		
	}
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.validatePageTitle();
		log.info("verifying the login page title");
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
				
	}
	@Test(priority=2)
	public void loginTest() throws Exception
	{
		log.info("Entering username and password");
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=3)
	public void FeaturesLinkTest()
	{
		Assert.assertTrue(loginpage.validateFeaturesLink());
	}
	@Test(priority=4)
	public void validatePricingLink()
	{
		boolean result=loginpage.validatePricingLink();
		Assert.assertEquals(result, true);
		
	}
	@Test(priority=4)
	public void validateSignUpLink()
	{
		boolean result=loginpage.validateSignupLink();
		Assert.assertEquals(result, true);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("closing the browser");
	}
	

}
