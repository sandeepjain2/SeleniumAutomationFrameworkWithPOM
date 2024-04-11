package com.cff.pages;

import org.openqa.selenium.By;

import com.cff.driver.DriverManager;
import com.cff.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage{


	private final By labelusename = By.className("oxd-userdropdown-name");
	private final By linklogout = By.className("oxd-userdropdown-link");


	public OrangeHRMHomePage clickLabelUsername() {
		//DriverManager.getDriver().findElement(labelusename).click();
		clickElement(labelusename, WaitStrategy.PRESENCE);
		return this;
	}

	public OrangeHRMLoginPage clickLinkLogout() {
		//DriverManager.getDriver().findElement(linklogout).click();
		clickElement(linklogout, WaitStrategy.CLICKABLE);
		return new OrangeHRMLoginPage();
	}

}
