package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryDemoWithCacheLookUp {
	
	@FindBy(name="q") private WebElement searchBox;

	private WebDriver driver;
	
	public PageFactoryDemoWithCacheLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this); // verbose
		this.driver = driver;
	}

	public void findElements10Times() {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i<10; i++) {
			searchBox.clear();
			searchBox.sendKeys("sandeep");
		}
		System.out.println("Time taken by PageFactoryDemoWithCacheLookUp Is :" + (System.currentTimeMillis() - startTime));
	}
	

}
