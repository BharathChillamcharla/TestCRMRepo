package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	DealsPage dealspage;
	public DealsPageTest() {
		
		super();
		
	}
	@BeforeMethod
	public void SetUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		testutil=new TestUtil();
		dealspage=new DealsPage();
		testutil.switchToFrame();
		homepage.ClickDealsLink();
		
	}
	@Test(priority=1)
	public void validateDealsLabel() throws IOException
	{
		dealspage.verifyDealsLabel();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}
	
	

	
	
	

}
