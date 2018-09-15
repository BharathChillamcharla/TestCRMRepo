package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	@FindBy(id="first_name")
	WebElement FirstName;
	@FindBy(id="surname")
	WebElement LastName;
	@FindBy(name="client_lookup")
	WebElement Company;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveBtn;
	
	//initializing the webelements
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
		
	}

	public void SelectContactsName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td//input[@name='contact_id']"));
	}
	
	public void CreateNewContact(String title,String firstname,String lastname,String company)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Company.sendKeys(company);
		SaveBtn.click();
		
	}
	
	
}
