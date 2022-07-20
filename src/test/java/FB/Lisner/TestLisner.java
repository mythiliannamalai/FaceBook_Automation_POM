package FB.Lisner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import FB.BaseClass.BaseClass;
import FB.Utility.UtilityClass;

public class TestLisner implements ITestListener {
	
	UtilityClass urility;
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
		urility = new UtilityClass();
		urility.failedTest(fTname);				
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
