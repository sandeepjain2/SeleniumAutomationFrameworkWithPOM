package com.cff.tests;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cff.driver.DriverManager;

public final class HomepageTests extends BaseTests {

	private HomepageTests() {

	}

	/*
	 * validate whether the title is containing Google Search or google search 
	 * validate whether the title is not null and lenght of title is > 15 and < 100
	 * check the link in the page --> Testing Mini Bytes
	 * number of links displayed in exactly 10 or 15
	 */


	//	@Test
	//	public void test1() {		
	//		DriverManager.getDriver().findElement(By.id("APjFqb")).sendKeys("Hell", Keys.ENTER);
	//	}

	//	@Test
	//	public void test2() {		
	//		DriverManager.getDriver().findElement(By.id("APjFqb")).sendKeys("Hell", Keys.ENTER);
	//	}


	@Test
	public void test3() {		
		DriverManager.getDriver().findElement(By.id("APjFqb")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		//Assert.isTrue(true, title, null);
		Assert.assertTrue(Objects.nonNull(title), "title is null");
		Assert.assertTrue(title.toLowerCase().contains("google search"), "google search doesn't contain");
		Assert.assertTrue(title.toLowerCase().matches("\\w.*" + "google search"), "google search doesn't contain");
		Assert.assertTrue(title.contains("Google Search"), "Google Search doesn't contain");
		Assert.assertTrue(title.length() > 15, "lenght is less than 15");
		Assert.assertTrue(title.length() < 100, "lenght is greater than 100");

		List <WebElement> elemList = DriverManager.getDriver().findElements(By.xpath("//h3[contains(text(),'Testing Mini Bytes')]"));
		Assert.assertEquals(elemList.size(), 5, "size is not matching");

		boolean isElementPresent = false;
		for(WebElement element : elemList) {
			if(element.getText().equalsIgnoreCase("Testing Mini Bytes")) {
				isElementPresent = true;
				break;				
			}
		}
		Assert.assertTrue(isElementPresent, "Testing Mini Bytes not contains");

	}



}
