package com.cff.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cff.driver.Driver;

public class BaseTests {

	protected BaseTests() { // cannot be private

	}

	/*

	Access modifier use: private, protected, default ----- public

	 */

	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}	


}
