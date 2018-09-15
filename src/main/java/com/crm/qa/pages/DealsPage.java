package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {

	//td[contains(text(),'Deals')]
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement DealsLabel;
	
		
	public DealsPage() throws IOException {
	
		PageFactory.initElements(driver, this);
	}
	public boolean verifyDealsLabel()
	{
		return DealsLabel.isDisplayed();
		
		
	}
	

}
