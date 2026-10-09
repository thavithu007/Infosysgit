package com.infosys.TestData;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.infosys.GlobalProperties.ExtentReporterNH;

public class Listener extends BaseData implements ITestListener {
	ExtentReports report = ExtentReporterNH.getReport();
	ExtentTest exTest;
	ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		exTest = report.createTest(result.getMethod().getMethodName());
		test.set(exTest);
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.get().log(Status.PASS, "Test Passed");
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.get().fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}catch (Exception e) {
			e.printStackTrace();

		}String path=null;
		try {
			 path = getScreenshot(result.getMethod().getMethodName(), driver);
		}catch (Exception e) {
			e.printStackTrace();

		}
			test.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());

		}

		

		

	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();

	}

}
