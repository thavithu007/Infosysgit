package com.infosys.TestData;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.infosys.Selenium.Landing;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BaseData {
	public WebDriver driver;
	public Landing landing;
	 public WebDriver initDriver() throws Exception {
		 Properties prop=new Properties();
		 FileInputStream fis=new FileInputStream("C:\\Users\\Vijayalakshmi\\democicd\\Selenium\\src\\main\\java\\com\\infosys\\GlobalProperties\\GlobalData.properties");
		 prop.load(fis);
		 String browserName=System.getProperty("browserName")!=null ?System.getProperty("browserName"):prop.getProperty("browserName");
		 if(browserName.contains("chrome")) {
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 
			 
			 
		 }else if(browserName.equalsIgnoreCase("edge")) {
			 driver=new EdgeDriver();
			 driver.manage().window().maximize();
			 
		 }
		 return driver;
		  }
	 @BeforeMethod
	 public Landing launchApp() throws Exception {
		 driver=initDriver();
		 landing=new Landing(driver);
		 driver.get("http://rahulshettyacademy.com/client");
		 return landing;
	 }
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
	public List<HashMap<String,String>> jsontoMap(String path) throws IOException{
		File file=new File(path);
		String json=FileUtils.readFileToString(file);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(json,new TypeReference<List<HashMap<String,String>>>() {});
		return data;
		
	}
	
	public String getScreenshot(String testcaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\Vijayalakshmi\\democicd\\Selenium\\Screenshot"+testcaseName+".png";
		File file=new File(path);
		FileUtils.copyFile(source,file);
		return path;
		
		
		
		
		
	}
	
	public void waittill() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tag")));
	}

		
		
		
		
	
}
