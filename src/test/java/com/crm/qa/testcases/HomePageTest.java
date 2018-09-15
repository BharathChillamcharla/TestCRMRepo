package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public HomePageTest() throws IOException
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		contactspage=new ContactsPage();
		testutil=new TestUtil();
		
	}
	
	@Test(priority=1)
	public void validateHomepagetitle()
	{
		String title=homepage.verifyPagetitle();
		Assert.assertEquals(title, "CRMPRO","title not matched");
	}
	@Test(priority=2)
	public void VerifyUsernameTest()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.validateUsernameLable());
		
	}
	@Test(priority=3)
	public void VerifyContactLinktest() throws IOException
	{	
		testutil.switchToFrame();
		contactspage=homepage.ContactsLink();
		
		
	}
	
@AfterMethod
public void tearDown()
{
	
	driver.quit();
}

}
