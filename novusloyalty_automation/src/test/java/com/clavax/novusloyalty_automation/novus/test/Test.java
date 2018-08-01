/**
 * 
 */
package com.clavax.novus.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.clavax.novusloyalty_automation.testBase.BaseClass;

import bsh.Capabilities;
import junit.framework.Assert;

/**
 * @author Vidushi Mishra
 *
 */
public class Test {

	WebDriver driver; 
//	String baseurl = "https://novusloyaltystaging.azurewebsites.net/Account/Login";
	public static final Logger log = Logger.getLogger(Test.class.getName());

	
	@BeforeTest
	public void init1() throws MalformedURLException{
		
		log.info("================Test execution starts here ============= ");
		System.setProperty("webdriver.gecko.driver", "D:\\Vidushi Mishra\\Novus\\Novus Automation\\FinalNovus-master\\novusloyalty_automation\\drivers\\geckodriver.exe");
		String	nodeurl = "http://192.168.2.169:5566/wd/hub"; 
		//this is node under hub system
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		//capability.setBrowserName("firefox");
		//capability.setPlatform(Platform.WIN10);
		//capability.setVersion("61.0");
		capability.setCapability("marionette", true);
		try {
			driver = new FirefoxDriver(capability);
			log.debug("------------- debug message here ----------");
			//driver = new RemoteWebDriver(new URL("http://192.168.2.63:5566/wd/hub"), capability);
			System.out.println(driver.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		
		
		
		
		
	}
	
	
	
	
	@org.testng.annotations.Test
	public void testparallelexecution(){
		
			driver.get("https://novusloyaltystaging.azurewebsites.net/Account/Login");
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			Assert.assertEquals("Log in Novus", driver.getTitle());
		
	
	}
	
	@AfterTest
	public void closetest(){
		
	}
}
