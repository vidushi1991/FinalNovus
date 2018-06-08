/**
 * 
 */
package com.clavax.novusloyalty_automation.homepage;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clavax.novusloyalty_automation.testBase.BaseClass;
import com.clavax.novusloyalty_automation.uiActions.HomePage;

/**
 * @author Vidushi Mishra
 *
 */
public class TC001_VerifyHomePageLoadedSuccessfully extends BaseClass {
	
	public static final Logger log = Logger.getLogger(TC001_VerifyHomePageLoadedSuccessfully.class.getName());

	
	HomePage homepage;
	
	@BeforeTest
	public  void setup()
	{
		init();
	}
	
	
	@Test
	public void verifyHomePageLoadedSuccessfully()
	{
		//driver.get(testURL);
		log.info("================Login with invalid Test Script Start here================= ");

		homepage =new HomePage(driver);
		homepage.loginToApplicaton("novus@cladev.com", "password1#");
		Assert.assertEquals(homepage.getInvalidLoginText(), "The email address or password that you've entered is incorrect");
		
		log.info("=================Login with invalid Test Script ends here=================== ");




	}
	
	@AfterTest
	public void endTest()
	{
		driver.close();
		driver.quit();
	}

}
