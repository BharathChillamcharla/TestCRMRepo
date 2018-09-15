package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.EventHandler;
import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static EventHandler eventlistner; 

	public static final String USERNAME="bharath526";
	public static final String ACCESS_KEY="8e39de15-d9bc-4477-9df9-834f2607905f";
	public static final String URL="https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	//public WebDriver driver;
	
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("F:\\Sample Work Space\\TestCRMProject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void initialization() throws MalformedURLException
	{
		
		
		/*DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("name", "cross_browser");
		cap.setCapability("platform", "Windows 10");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("version", "53.0");
		cap.setCapability("build", "Selenium_SauceLab_s");
		driver =new RemoteWebDriver(new URL(URL),cap);
		*///driver.get("https://www.facebook.com");
		
		
		/*String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
		  System.setProperty("webdriver.chrome.driver", "F:\\Selenium jar\\Lib\\Drivers\\chromedriver\\chromedriver.exe");
		  driver=new ChromeDriver();
		}else if(browsername.equals("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver", "F:\\Selenium jar\\Lib\\geckodriver.exe");
			 // driver=new FirefoxDriver();
			  FirefoxOptions options = new FirefoxOptions();
			  options.setCapability("marionette", false);
			  driver = new FirefoxDriver(options);

		}
		e_driver=new EventFiringWebDriver(driver);
		eventlistner=new EventHandler();
		e_driver.register(eventlistner);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_LOAD_TIMEOUT, TimeUnit.SECONDS);
*/		//driver.get(prop.getProperty("url"));
		
	}
	
	
	

}
