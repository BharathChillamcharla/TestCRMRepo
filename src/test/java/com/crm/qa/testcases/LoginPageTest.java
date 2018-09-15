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

	@Parameters({"platform","browser","version"})
	@BeforeMethod
	public void SetUp(String platform,String browser,String version) throws IOException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("name", "cross_browser");
		cap.setCapability("platform", platform);
		cap.setCapability("browserName", browser);
		cap.setCapability("version", version);
		cap.setCapability("build", "Selenium_SauceLab_Cross_Parallel");
		driver =new RemoteWebDriver(new URL(URL),cap);
		driver.get(prop.getProperty("url"));
		initialization();
		loginpage=new LoginPage();
		
		
	}
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.validatePageTitle();
		log.info("verifying the login page title");
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
				
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
	public void validateLinks()
	{
		loginpage.validateLinks();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("closing the browser");
	}
	

}
