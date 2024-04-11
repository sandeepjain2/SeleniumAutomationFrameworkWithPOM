package com.cff.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class ThreadLocalWebDriverWithInitialValue {
	
	private ThreadLocalWebDriverWithInitialValue() {
		
	}


	private static ThreadLocal <WebDriver> dr = ThreadLocal.withInitial(()->{
		System.setProperty("webDriver.chrome.driver", "src/test/resources/Executables/chromedriver.exe");
		return new ChromeDriver();		
	});

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);		
	}

	public static void unload() {
		dr.remove();
	}


}
