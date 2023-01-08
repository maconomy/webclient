package utilities;


import org.testng.ITestListener;
import org.testng.ITestResult;

import factory.Factory;


public class TestListener extends ScreenshotUtility implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("test log: " + result.getMethod().getMethodName() + " Started!");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("test log: " + "Test Passed: " + result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("test log: " + "Test Failed: " + result.getMethod().getMethodName());
		try {
			System.out.println("test log: " + "Taking screenshot...");
			takeScreenshot();
		} catch (Exception e){
			System.out.println("test log: " + "unable to take screenshot...");
			e.printStackTrace();
		}
	}
	
	
}
