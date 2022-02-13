package avinash.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class CaptureScreenShot 
{
	WebDriver driver = null;
	String imagePath = null;
	public CaptureScreenShot() 
	{
		
	}
	
	
	public String getScreenShotPath(String testName, WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver ;
		File source = ts.getScreenshotAs(OutputType.FILE);
		imagePath = System.getProperty("user.dir")+"\\src\\main\\resources\\avinash\\screenshot\\"+testName+".png";
		File destination = new File(imagePath);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imagePath;
	}

}
