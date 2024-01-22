package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyListener implements ITestListener{
	
	ExtentReports e;
	ExtentTest t;
	ScreenshotUtiity s;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case started ");
		t.log(LogStatus.INFO, result.getMethod().getMethodName()+"has started");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case passed");
		try
		{
		t.log(LogStatus.PASS, "Screenshot "+ t.addScreenCapture(s.takeScreeshot()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case failed");
		t.log(LogStatus.FAIL, result.getMethod().getMethodName()+"has failed");

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case skipped");
		t.log(LogStatus.SKIP, result.getMethod().getMethodName()+"has skipped");

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onStart(ITestContext context) {
		s= new ScreenshotUtiity();
		System.out.println("TestNG started ");
		e=new ExtentReports("test-output//MyReport.html");
		t=e.startTest("LoginTest has started");
		e.addSystemInfo("Browser", "Chrome");
		e.addSystemInfo("Build", "smoke Testing");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("TestNG finished");
		e.endTest(t);
		e.flush();
	}

}
