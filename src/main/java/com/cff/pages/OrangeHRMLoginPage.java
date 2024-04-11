package com.cff.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.cff.driver.DriverManager;
import com.cff.enums.WaitStrategy;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public final class OrangeHRMLoginPage extends BasePage{

	/*
	 * id
	 * name
	 * class name
	 * link text
	 * partial link text
	 * xpath or css
	 * 
	 * Assertion should not be in the page layers
	 * 
	 * All page layers need to have a return type
	 * 
	 */

	private final By textboxusename = By.name("username");
	private final By textboxpassword = By.xpath("//*[@name='password' and @type='password']");
	private final By buttonlogin = By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button' and @type='submit']");


	public OrangeHRMLoginPage enterUserName(String username) {
		//DriverManager.getDriver().findElement(textboxusename).sendKeys(username);
		inputTextValue(textboxusename, username, WaitStrategy.PRESENCE);
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		//DriverManager.getDriver().findElement(textboxpassword).sendKeys(password);
		inputTextValue(textboxpassword, password, WaitStrategy.PRESENCE);
		return this;
	}

	public OrangeHRMHomePage clickLoginButton() {
		//DriverManager.getDriver().findElement(buttonlogin).click();
		clickElement(buttonlogin, WaitStrategy.PRESENCE);
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}

	


}
