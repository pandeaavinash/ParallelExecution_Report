package avinash.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import avinash.browser.Browser;

public class SauceDemo_2 extends Browser
{
	public WebDriver driver = null;
	
	@Test(description = "Login Sauce Demo Test but failed to login")
	public void LoginTest_failedToLogin_3() 
	{
		this.setBrowser("chrome");
		driver = this.threadLocal.get();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	@Test(description = "Login Sauce Demo Test & but failed to  verify page title")
	public void LoginTest_verifyPageTitle_4() 
	{
		this.setBrowser("chrome");
		driver = this.threadLocal.get();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labsss");
	}
}
