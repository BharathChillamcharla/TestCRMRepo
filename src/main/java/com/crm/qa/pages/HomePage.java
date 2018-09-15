package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;


public class HomePage extends TestBase  {
	
	@FindBy(xpath="//td[contains(text(),'User: bharath chillamcharla ')]")
	WebElement userLabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewcontactsLink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	
	public HomePage() throws Exception
	{
		PageFactory.initElements(driver, this);
				
	}
	public String verifyPagetitle()
	{
		return driver.getTitle();
	}
	public boolean validateUsernameLable()
	{	
		
		return userLabel.isDisplayed();
		
	}
	public ContactsPage ContactsLink() throws IOException
	{
		
		contactsLink.click();
		return new ContactsPage();
	}
	public void clickNewContactsLink() throws InterruptedException
	
	{
		//driver.navigate().refresh();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(NewcontactsLink));
		NewcontactsLink.click();
		
		
	}
	public DealsPage ClickDealsLink() throws IOException
	{
		
		DealsLink.click();
		return new DealsPage();
	}

	
	
	
	
}