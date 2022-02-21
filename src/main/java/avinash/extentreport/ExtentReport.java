package avinash.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport 
{
	static ExtentReports extent = null;
	
	public static ExtentReports generateExentReport()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		System.out.println("Path:"+path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Avinash Automation Report");
		reporter.config().setDocumentTitle("Avinash Document");
		reporter.config().enableTimeline(true);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setCSS(".black-text { color: #fff !important; }");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Avinash Pande");
		return extent;
		
	}

}
