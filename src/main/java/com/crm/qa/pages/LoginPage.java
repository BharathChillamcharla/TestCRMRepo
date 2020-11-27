package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {
//PageFactory -OR
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit' and @class='btn btn-small']")
	WebElement loginBtn;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignupBtn;
	@FindBy(xpath="//img[contains(@alt,'free crm logo')]")
	WebElement crmlogo;
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement FeaturesLink;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignupLink;
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement PricingLink;
	@FindBy(xpath="//a[contains(text(),'Customers')]")
	WebElement CustomersLink;
	
	//initializing the page objects
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
				
	}
	//Actions
	public String validatePageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();
	}
	public boolean validateFeaturesLink()
	{
		return FeaturesLink.isDisplayed();
	}
	public boolean validatePricingLink()
	{
		 boolean Signupflag=PricingLink.isDisplayed();
		 
		return Signupflag;
		
	}
	public boolean validateSignupLink()
	{
		
		boolean Signupflag=SignupLink.isDisplayed();
		return Signupflag;
		
	}
	public HomePage login(String un,String pwd) throws Exception 
	{
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	

}
