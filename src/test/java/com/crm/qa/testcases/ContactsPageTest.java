package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	String SheetName="Contacts";
	
	
	public ContactsPageTest()
	{
		super();
			
	}
	
	@BeforeMethod
	public void Setup() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		contactspage=new ContactsPage();
		testutil=new TestUtil();
		testutil.switchToFrame();		
		contactspage=homepage.ContactsLink();
			
	}
	@Test(priority=1)
	public void ValidateContactsLabelTest() throws IOException
	{
		Assert.assertTrue(contactspage.verifyContactsLabel());
		
	}
	@Test(priority=2)
	public void selectcontactnameTest()
	{
		contactspage.SelectContactsName("test1 test 2");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
	
		Object data[][]=TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(priority=3,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company) throws InterruptedException
	{
		homepage.clickNewContactsLink();
		contactspage.CreateNewContact(title, firstname, lastname, company);
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
