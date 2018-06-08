/**
 * 
 */
package com.clavax.novusloyalty_automation.uiActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.clavax.novusloyalty_automation.testBase.BaseClass;

/**
 * @author Vidushi Mishra
 *
 */
public class HomePage extends BaseClass{
	
	@FindBy(xpath="//a[@id='LoginId']")
	WebElement visitloginpage;
	
	@FindBy(id="emailId")
	WebElement loginEmailAddress;
	
	@FindBy(id="passwordId")
	WebElement loginPassword;
	
	@FindBy(id="signId")
	WebElement submitPage;

	@FindBy(xpath="//p[@class='validation-summary-errors']")
	WebElement Loginfailed;
	
	@FindBy(id="SignUpId")
	WebElement freeTrailPage;
	
	@FindBy(id="firstNameId")
	WebElement firstName;
	
	@FindBy(id="lastNameId")
	WebElement lastName;
	
	@FindBy(id="emailId1")
	WebElement emailAddress;
	
	@FindBy(id="passwordId")
	WebElement password;
	
	@FindBy(id="tConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="submitId")
	WebElement submitButton;
	
	@FindBy(id="IdVerify")
	WebElement verifyotpsubmitbutton;
	
	@FindBy(id="pMsg")
	WebElement verificationFailed;
	
	@FindBy(xpath="//h4")
	WebElement successfullLogin;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
		
	public void loginToApplicaton(String username, String password)
	{
		visitloginpage.click();
		log.info("You have successfully clicked on login page  :" +visitloginpage.toString());

		loginEmailAddress.sendKeys(username);
		log.info("You have successfully entered email address on login page  :" +loginEmailAddress.toString());

		loginPassword.sendKeys(password);
		log.info("You have successfully entered password on login page  :" +loginPassword.toString());

		submitPage.click();
		log.info("You have successfully clicked on submit page  :" +submitPage.toString());

		
		
	}
	
	public String getInvalidLoginText(){
		log.info("You have successfully captured the message for failed login  :" +Loginfailed.getText());

		return Loginfailed.getText();

		
	}
	
	public void newUserRegistration(String firstName, String lastName, String emailAddress, String password, String confirmPassword)
	{
		driver.findElement(By.id("SignUpId")).click();
		log.info("You have successfully clicked on free trial page  :" +freeTrailPage.toString());

		driver.findElement(By.id("firstNameId")).clear();
		log.info("You have successfully clear first name field  :" +this.firstName.toString());

		driver.findElement(By.id("firstNameId")).sendKeys(firstName);
		log.info("You have successfully entered  first name  :" +this.firstName.toString());

		driver.findElement(By.id("lastNameId")).clear();
		log.info("You have successfully clear last name field  :" +this.lastName.toString());

		driver.findElement(By.id("lastNameId")).sendKeys(lastName);
		log.info("You have successfully entered  last name  :" +this.lastName.toString());
		
		driver.findElement(By.id("emailId1")).clear();
		log.info("You have successfully clear email field  :" +this.emailAddress.toString());

		driver.findElement(By.id("emailId1")).sendKeys(emailAddress);
		log.info("You have successfully entered  email  field  :" +this.emailAddress.toString());

		driver.findElement(By.id("passwordId")).clear();
		log.info("You have successfully clear password field  :" +this.password.toString());

		driver.findElement(By.id("passwordId")).sendKeys(password);
		log.info("You have successfully entered  password  field  :" +this.password.toString());

		driver.findElement(By.id("tConfirmPassword")).clear();
		log.info("You have successfully clear confirsm password field  :" +this.confirmPassword.toString());

		driver.findElement(By.id("tConfirmPassword")).sendKeys(confirmPassword);
		log.info("You have successfully entered  confirm password  field  :" +this.confirmPassword.toString());

		driver.findElement(By.id("submitId")).click();
		log.info("You have successfully clicked on submit button  :" +submitButton.toString());

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.id("IdVerify")).click();
		log.info("You have successfully clicked on otp verify by button  :" +verifyotpsubmitbutton.toString());

		

	}
	
	public String getInvalidVerificationCode(){
		log.info("You have successfully captured the message for failed login  :" +verificationFailed.getText());
		return verificationFailed.getText();
	}
	
	public String getValidLoginText(){
		log.info("You have successfully logged in to the Novus  :" +successfullLogin.getText());

		return successfullLogin.getText();

	}
}




