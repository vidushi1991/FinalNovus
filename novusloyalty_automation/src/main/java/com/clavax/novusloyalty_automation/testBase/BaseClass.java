/**
 * 
 */
package com.clavax.novusloyalty_automation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.steadystate.css.dom.Property;

/**
 * @author Vidushi Mishra
 *
 */
public class BaseClass {
	
	public static final Logger log = Logger.getLogger(BaseClass.class.getName());
	
	public static WebDriver driver;
	  String testUrl ="https://novusloyaltystaging.azurewebsites.net/Home/Index";
	  String browser ="chrome";
	  
	  public void init()
	  {
		  selectBrowser(browser);
		  getUrl(testUrl);
		  String log4jconfpath = "log4j.properties";
		  PropertyConfigurator.configure(log4jconfpath);
	  }
	
	
	
	
	
	public void selectBrowser(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\2018\\Selenium\\workspace\\novusloyalty_automation\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--enable-automation");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
		}
		
	}

	
	public void getUrl(String url){
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
}
