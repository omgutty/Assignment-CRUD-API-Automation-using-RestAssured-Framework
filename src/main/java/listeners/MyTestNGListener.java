package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class MyTestNGListener implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		ChainTestListener.log("Listener:- Test Passed "+result+ result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		ChainTestListener.log("Listener:- Test Failed" + result.getThrowable().getMessage());	
	}

	public void onTestSkipped(ITestResult result) {
		ChainTestListener.log("Listener:- Test skipped" + result.getThrowable().getMessage());
	}

	public void onStart(ITestContext context) {
		ChainTestListener.log("Listener: Test Started" + context.getClass().getName());
	}

	public void onFinish(ITestContext context) {
		ChainTestListener.log("Listener: Test Finished" + context.getClass().getName());
	}
}
