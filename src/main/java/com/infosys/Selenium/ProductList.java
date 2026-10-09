package com.infosys.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductList {
	WebDriver driver;

	public ProductList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By addCart=By.xpath("//div[@class='card-body']/button[2]");
	
	public void getProduct(String product) throws InterruptedException {
		System.out.println(product);
		Thread.sleep(5000);
		WebElement prod=products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().contains(product)).findFirst().orElse(null);
		prod.findElement(addCart).click();
		
		
			
			
		}
	}


