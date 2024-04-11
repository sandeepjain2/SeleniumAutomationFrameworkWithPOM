package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cff.constants.FrameworkConstants;

public class Runner {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webDriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
		driver = new ChromeDriver();	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test //1405
	public void test1() {
		driver.get("https://www.google.com");
		PageFactoryDemo pfd = new PageFactoryDemo(driver);
		pfd.findElements10Times();

	}

	@Test //1414
	public void test2() {
		driver.get("https://www.google.com");
		PageFactoryDemoWithCacheLookUp pfdwclu = new PageFactoryDemoWithCacheLookUp(driver);
		pfdwclu.findElements10Times();

	}

	@Test //1283
	public void test3() {
		driver.get("https://www.google.com");
		IRecommendNoPageFactoryDemo irnpfd = new IRecommendNoPageFactoryDemo(driver);
		irnpfd.findElements10Times();

	}

}
