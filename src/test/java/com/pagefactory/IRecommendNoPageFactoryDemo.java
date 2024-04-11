package com.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IRecommendNoPageFactoryDemo {

	private By searchBox = By.name("q");

	private WebDriver driver;

	public IRecommendNoPageFactoryDemo(WebDriver driver) {
		this.driver = driver;
	}

	public void findElements10Times() {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i<10; i++) {
			WebElement element =  driver.findElement(searchBox);
			element.clear();
			element.sendKeys("sandeep");
		}
		System.out.println("Time taken by IRecommendNoPageFactoryDemo Is :" + (System.currentTimeMillis() - startTime));
	}

}
