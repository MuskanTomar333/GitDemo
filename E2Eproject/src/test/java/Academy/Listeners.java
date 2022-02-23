package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.ExtentReporterNG;

public class Listeners extends base implements ITestListener{
	ExtentReports reports=ExtentReporterNG.getReportObject();
	ExtentTest logger;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();//for running parallel test cases case
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());//or logger.fail(result.getThrowable());
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());//to get specific driver of that test case
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String dest=getScreenshotPath(testMethodName,driver);
			
		extentTest.get().addScreenCaptureFromPath(dest, testMethodName); //or getScreenshotPath(testMethodName,driver); if screenshot is not needed in extentReports
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().skip("Test skipped");//or logger.skip("Test skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger=reports.createTest(result.getMethod().getMethodName());
		extentTest.set(logger);//for running parallel test cases case
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test passed");//or logger.log(Status.PASS, "Test passed");
	}

}
