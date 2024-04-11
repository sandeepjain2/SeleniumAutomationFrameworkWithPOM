package com.cff.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cff.constants.FrameworkConstants;
import com.cff.driver.DriverManager;
import com.cff.enums.WaitStrategy;
import com.cff.factories.ExplicitWaitFactory;

public class BasePage {

	protected static WebElement waitForElementWithFluentWait(By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver())
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	//	protected void clickElement(By by) {
	//		explicitlyWaitElementToBeClickable(by);
	//		DriverManager.getDriver().findElement(by).click();
	//	}

	protected void clickElement(By by, WaitStrategy waitstrategy) {
		//		if(waitstrategy == WaitStrategy.CLICKABLE) {
		//			explicitlyWaitElementToBeClickable(by);
		//		} else if (waitstrategy == WaitStrategy.PRESENCE) {
		//			explicitlyWaitElementToBePresent(by);
		//		}
		WebElement element = ExplicitWaitFactory.explicitWait(waitstrategy, by);
		element.click();
		//DriverManager.getDriver().findElement(by).click();
	}

	//	protected void inputTextValue(By by, String value) {
	//		explicitlyWaitElementToBeClickable(by);
	//		DriverManager.getDriver().findElement(by).sendKeys(value);
	//	}

	protected void inputTextValue(By by, String value, WaitStrategy waitstrategy) {
		//		if(waitstrategy == WaitStrategy.CLICKABLE) {
		//			explicitlyWaitElementToBeClickable(by);
		//		} else if (waitstrategy == WaitStrategy.PRESENCE) {
		//			explicitlyWaitElementToBePresent(by);
		//		}
		WebElement element = ExplicitWaitFactory.explicitWait(waitstrategy, by);
		element.sendKeys(value);
		//DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	private void explicitlyWaitElementToBeClickable(By by) {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
		.until(ExpectedConditions.elementToBeClickable(by));
	}

	private void explicitlyWaitElementToBePresent(By by) {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
		.until(ExpectedConditions.presenceOfElementLocated(by));
	}

}
