package genericUtilities;

import java.io.IOException;
import genericUtilities.JavaFileUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenersImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName=result.getMethod().getMethodName();
		System.out.println(testScriptName+"====test script execution started======");
		//create a test script - recognise each @Test
		test = report.createTest(testScriptName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName=result.getMethod().getMethodName();
		System.out.println(testScriptName+"====passed======");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName=result.getMethod().getMethodName();
		System.out.println(testScriptName+"====failed======");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//log for failure
		test.log(Status.FAIL, testScriptName+" == Fail ==");
		test.log(Status.INFO, result.getThrowable());
		
		//screenshot
		String screenShotName=testScriptName+new JavaFileUtility().getSystemDate();
		WebDriverUtility w = new WebDriverUtility();
		try {
			String path = w.takeScrennShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName=result.getMethod().getMethodName();
		System.out.println(testScriptName+"====skipped======");
		
		
		//Exception for failure
		System.out.println(result.getThrowable());
		//log for Skip
				test.log(Status.SKIP, testScriptName+" == skipped ==");
				test.log(Status.INFO, result.getThrowable());
	}
		
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		// TODO Auto-generated method stub
		System.out.println("====suite execution started=======");
		
		//Basic Report configuration//Report 17-10-2023-20-41-32.html
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaFileUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger execution Report");
		
	    report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Chaitra");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("======suite execution finished========");
		//Report genertion
		report.flush();
	}
	

}
