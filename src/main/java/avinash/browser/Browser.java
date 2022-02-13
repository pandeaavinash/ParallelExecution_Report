package avinash.browser;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import avinash.extentreport.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser
{
	protected ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	WebDriver driver = null;
	
	
	/***
	 * Set the Browser and add instance in thread local	
	 * @param browser BrowserName e.g. ff or firefox
	 */
	public void setBrowser(String browser)
	{		
		
		if(browser.toLowerCase().equalsIgnoreCase("ff") || browser.equalsIgnoreCase("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver",
		                "C:\\Users\\Avinash\\Downloads\\geckodriver_v30\\geckodriver.exe");
		 
		        driver = new FirefoxDriver();
		 
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		        threadLocal.set(driver);
		}
		if(browser.toLowerCase().equalsIgnoreCase("gc") || browser.equalsIgnoreCase("chrome"))
		{
			/*
			 * System.setProperty("webdriver.chrome.driver", ""); driver = new
			 * ChromeDriver();
			 * 
			 * driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 * threadLocal.set(driver);
			 */
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			threadLocal.set(driver);
		}
		if(browser.toLowerCase().equalsIgnoreCase("ie") || browser.equalsIgnoreCase("internetexplore"))
		{
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();

			driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	        threadLocal.set(driver);
		}
		
	}
	
	/***
	 * Get the driver from thread local
	 * @return
	 */
	public final WebDriver getDriver()
	{
		return threadLocal.get();
	}
	
	/***
	 * Remove the driver instance from thread local
	 */
	public final void removeDriver()
	{
		threadLocal.remove();
	} 

}
