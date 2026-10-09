package com.infosys.Selenium;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.infosys.TestData.BaseData;
import com.infosys.TestData.Retry;

public class FirstCases extends BaseData {
	
	@Test(dataProvider="getData",groups= {"Good"})
	public void trail(HashMap<String,String> input) throws Exception {
		ProductList list=landing.logIn(input.get("eMail"),input.get("passWord"));
		list.getProduct(input.get("product"));
		
	}
	@Test(dataProvider="getData",groups= {"Error"})
	public void trail2(HashMap<String,String> input) throws Exception {
		ProductList list=landing.logIn(input.get("eMail"),input.get("passWord"));
		list.getProduct(input.get("product"));
		
	}
	
	
		
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		String path="C:\\Users\\Vijayalakshmi\\democicd\\Selenium\\src\\main\\java\\com\\infosys\\GlobalProperties\\Data.json";
		List<HashMap<String,String>> data=jsontoMap(path);
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
	
	

}
