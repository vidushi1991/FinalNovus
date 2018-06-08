/**
 * 
 */
package com.clavax.novusloyalty_automation.registrationpage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clavax.novusloyalty_automation.homepage.TC001_VerifyHomePageLoadedSuccessfully;
import com.clavax.novusloyalty_automation.testBase.BaseClass;
import com.clavax.novusloyalty_automation.uiActions.HomePage;

/**
 * @author Vidushi Mishra
 *
 */
public class TC002_VerifyRegistrationPage extends BaseClass{
	
	public static final Logger log = Logger.getLogger(TC002_VerifyRegistrationPage.class.getName());

	
	HomePage homepage;
	
	@BeforeTest
	public void setup(){
		init();
		
	}
	@Test
	public void VerifyRegistrationPage(){
		
		log.info("===============Verify registrtion page script will start from here ===============");
		homepage =new HomePage(driver);		
		homepage.newUserRegistration("testfnameuser", "testuserlast", "testuser3@tester.com", "Password1#", "Password1#");
		Assert.assertEquals(homepage.getInvalidVerificationCode(), "Please enter verification code");
		log.info("===============Verify registrtion page script will End here ===============");

		
	}
	@AfterTest
	public void close()
	{
		driver.close();
		driver.quit();
		
	}
}
