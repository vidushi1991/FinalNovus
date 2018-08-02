/**
 * 
 */
package com.clavax.novusloyality.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Vidushi Mishra
 *
 */
public class BaseClass1 {
	
	public ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	
	@BeforeTest
	@Parameters({"myBrowser"})
	public  void setup(String myBrowser) throws MalformedURLException {
		
		RemoteWebDriver driver =null;
		
		if(myBrowser.equals("chrome"))
		{
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			//capability.setVersion(version);
			driver =new RemoteWebDriver(new URL("http://192.168.43.160:5566/wd/hub"), capability);
			System.out.println("-------open chrome browser----------");
			
		}
		
		else if(myBrowser.equals("firefox"))
		{
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			driver =new RemoteWebDriver(new URL("http://192.168.43.160:5001/wd/hub"), capability);
			System.out.println("-------open chrome browser----------");

			
		}
		
		else if(myBrowser.equals("safari")){
			
		}
		setWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		System.out.println("-------------open and maximize driver------------");
		
		}
	
		public WebDriver getDriver()
			{
				return dr.get();
			}
		
		public void setWebDriver(RemoteWebDriver driver) {
			dr.set(driver);
			
		}
		
		
		@AfterClass
		public void close(){
			//getDriver().quit();
			
		}
		@Test
		public void openHomepage(){
			dr.get().get("https://www.google.com/");
			System.out.println("---------------open google.com-----------");
		}
		
		

			

}
