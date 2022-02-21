package lambdatest.listeners;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import lambdatest.extentreport.ExtentReport;
import lambdatest.utility.*;

public class TestListeners implements ITestListener
{
	ExtentReports extentReport = ExtentReport.generateExentReport();
	ExtentTest test = null;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extentReport.createTest(result.getMethod().getMethodName(), null);
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Successful");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		
		//To get the driver
		WebDriver driver = null;
		Object currentTestMethodThreadInstance = result.getInstance();
		Class<?> realClass = result.getTestClass().getRealClass();
		try {
			driver = (WebDriver) realClass.getDeclaredField("driver").get(currentTestMethodThreadInstance);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Capture Screenshot
		CaptureScreenShot obj_screenShot = new CaptureScreenShot(); 
		try {
			extentTest.get().addScreenCaptureFromPath(obj_screenShot.getScreenShotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			extentTest.get().info("<b>Not able to capture the screenshot!!</b>");
		}
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip(result.getSkipCausedBy().toString());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
	}
	

}
