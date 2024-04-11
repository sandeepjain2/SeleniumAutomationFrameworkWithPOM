package com.cff.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cff.constants.FrameworkConstants;
import com.cff.enums.ConfigProperties;
import com.cff.utils.JsonUtils;
import com.cff.utils.PropertyUtils;

public final class Driver {

	private Driver() {

	}

	//private static WebDriver driver;

	public static WebDriver initDriver() throws Exception {
		
		System.out.println(Thread.currentThread().getId() + " : " + DriverManager.getDriver());

		//Lazy initialization

		if(Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webDriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
			WebDriver driver = new ChromeDriver();

			// wait for sometime
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			
			// fetching the current window size with getSize()
			System.out.println(driver.manage().window().getSize());
			
			// Create object of Dimensions class
			Dimension dm = new Dimension(900,600);
			
			// Setting the current window to that dimension
			driver.manage().window().setSize(dm);

			// driver.manage().window().maximize();
			DriverManager.setDriver(driver);
			
			// driver.get("https://www.google.com/");
//			DriverManager.getDriver().get(PropertyUtils.getValueByHashmap("url"));
			DriverManager.getDriver().get(PropertyUtils.getValueByHashmap(ConfigProperties.URL));
			//DriverManager.getDriver().get(JsonUtils.getValueByHashmapUsingJson(ConfigProperties.URL));
			Thread.sleep(5000);
		}
		return null;
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			//		driver.quit();
			//		driver = null;	
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}	

}
