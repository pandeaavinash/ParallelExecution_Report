package lambdatest.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import lambdatest.driver.Browser;
import lambdatest.extentreport.ExtentReport;

public class SauceDemo_1 extends Browser
{
	public WebDriver driver = null;
	
	@Test(description = "Login Sauce Demo Test")
	public void LoginTest_1() 
	{
		
		this.setBrowser("chrome");
		driver = this.threadLocal.get();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//driver.getTitle();
		//Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	@Test(description = "Login Sauce Demo Test & verify page title")
	public void LoginTest_verifyPageTitle_2() 
	{
		this.setBrowser("chrome");
		driver = this.threadLocal.get();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
}
