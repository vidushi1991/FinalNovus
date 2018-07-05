/**
 * 
 */
package com.clavax.novusloyalty_automation.chooseprogram;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clavax.novusloyalty_automation.testBase.BaseClass;
import com.clavax.novusloyalty_automation.uiActions.HomePage;

/**
 * @author Vidushi Mishra
 *
 */
public class TC003_VerifyProgramLoaded extends BaseClass{
	HomePage homepage;
	
	@BeforeTest
	public void setup()
	{
		init();
	}
	@Test(priority=1)
	public void VerifyValidLogin()
	
	{
		log.info("===============Verify valid login page script will start from here ===============");
			
		homepage =new HomePage(driver);
		homepage.loginToApplicaton("novus@cladev.com", "Nov@4321");
		Assert.assertEquals(homepage.getValidLoginText(), "Welcome to Novus");
	
		log.info("===============Verify valid login page script will ends here ===============");

	}
	@Test(priority=2)
	public void VerifyProgramLoaded() throws InterruptedException
	
	{
		log.info("===============Verify Choose program script will start from here ===============");
		
		

		try {
			WebElement chooseProgram = driver.findElement(By.id("optionPrograms"));

			Select dropdown= new Select(chooseProgram);
			
			dropdown.selectByVisibleText("TempeGolfTest (TGT)");
			
			String welcomeprogramowner = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/h4")).getText();
			
			System.out.println(welcomeprogramowner);
			
			Assert.assertEquals("Welcome to Novus as Program Owner", welcomeprogramowner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		

	
		log.info("===============Verify Choose program script will ends here ===============");

	}
	@AfterTest
	public void close()
	{
		driver.close();
		driver.quit();
	}

}
