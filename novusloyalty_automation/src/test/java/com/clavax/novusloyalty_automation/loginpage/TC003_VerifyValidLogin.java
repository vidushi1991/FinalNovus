/**
 * 
 */
package com.clavax.novusloyalty_automation.loginpage;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clavax.novusloyalty_automation.registrationpage.TC002_VerifyRegistrationPage;
import com.clavax.novusloyalty_automation.testBase.BaseClass;
import com.clavax.novusloyalty_automation.uiActions.HomePage;

/**
 * @author Vidushi Mishra
 *
 */
public class TC003_VerifyValidLogin extends BaseClass {
	
	public static final Logger log = Logger.getLogger(TC003_VerifyValidLogin.class.getName());

	HomePage homepage;
	
	@BeforeTest
	public void setup()
	{
		init();
	}
	@Test
	public void VerifyValidLogin()
	
	{
		log.info("===============Verify valid login page script will start from here ===============");
			
		homepage =new HomePage(driver);
		homepage.loginToApplicaton("novus@cladev.com", "Cla@1234");
		Assert.assertEquals(homepage.getValidLoginText(), "Welcome to Novus");
	
		log.info("===============Verify valid login page script will ends here ===============");

	}
	@AfterTest
	public void close()
	{
		driver.close();
		driver.quit();
	}

}
