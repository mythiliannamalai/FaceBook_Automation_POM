package FB.Lisner;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import FB.BaseClass.BaseClass;

public class TestLisner extends BaseClass implements ITestListener {
	BaseClass bclass;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result){
		System.out.println(result.getMethod().getMethodName()+" :onTestFailure");  
		String fTname=result.getMethod().getMethodName();
		bclass = new BaseClass();
		bclass.failedTest();				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context);
	}

}
