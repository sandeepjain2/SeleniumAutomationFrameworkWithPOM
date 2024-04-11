package com.cff.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.cff.driver.DriverManager;

public final class LoginpageTests extends BaseTests {

	private LoginpageTests() {

	}


	@Test
	public void test1() {
		DriverManager.getDriver();
		DriverManager.getDriver().findElement(By.id("APjFqb")).sendKeys("Hello", Keys.ENTER);
	}
	
	@Test
	public void test2() {
		DriverManager.getDriver();
		DriverManager.getDriver().findElement(By.id("APjFqb")).sendKeys("Hello", Keys.ENTER);
	}

}
