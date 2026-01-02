package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import config.ConfigReader;

//handle flaky test, unstable test 
public class RetryAnalyzer implements IRetryAnalyzer
{
	private int retrycount= 0;
	private int maxretrycount=Integer.parseInt(new ConfigReader().get("maxretrycount"));
	//private int maxretrycount=2;
	
	public boolean retry(ITestResult result) {
		
		if (retrycount<maxretrycount) {
			retrycount++;
			System.out.println("Retry tests"+result.getMethod().getMethodName()+"Attempt : "+retrycount);
			return true;
		}
		return false;
	}

}