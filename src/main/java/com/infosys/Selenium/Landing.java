package com.infosys.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing {
	WebDriver driver;
	

	
public Landing(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(id="userEmail")
WebElement email;

@FindBy(id="userPassword")
WebElement password;

@FindBy(id="login")
WebElement login;

public ProductList logIn(String eMail,String passWord) {
	email.sendKeys(eMail);
	password.sendKeys(passWord);
	login.click();
	ProductList product=new ProductList(driver);
	return product;
	
	
}


}
