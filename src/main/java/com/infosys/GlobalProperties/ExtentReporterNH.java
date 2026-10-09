package com.infosys.GlobalProperties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNH {
	public static ExtentReports getReport() {
		String path="C:\\Users\\Vijayalakshmi\\democicd\\Selenium\\Report\\index.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("Nova");
		spark.config().setReportName("Nova Results");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(spark);
		return reports;
		
	}

}
