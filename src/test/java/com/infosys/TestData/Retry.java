package com.infosys.TestData;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int count=1;
	int maxtry=2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxtry) {
			count++;
			return true;
			
		}
		return false;
		
	}

}
