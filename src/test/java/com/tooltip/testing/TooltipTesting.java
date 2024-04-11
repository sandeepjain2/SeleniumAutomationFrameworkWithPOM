package com.tooltip.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TooltipTesting {

	public static WebDriver driver;

	protected static String RefMsg = "Sample text for your tooltip!";

	//	public void validateTooltipMsg(String RefMsg) {
	//
	//	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Set system properties for geckodriver This is required since Selenium 3.0 
		System.setProperty("webdriver.chrome.driver", "E:\\Dependency\\Driver\\chromedriver.exe"); 

		// Create a new instance of the Firefox driver 
		driver = new ChromeDriver(); 

		//CASE 2 : Using Actions class method 
		driver.get("https://codepen.io/cristina-silva/pen/XXOpga");
		Thread.sleep(5000);
		System.out.println("https://codepen.io/cristina-silva/pen/XXOpga"); 

		//Maximise browser window 
		driver.manage().window().maximize(); 
		
		//Switching to current frame
		driver.switchTo().frame("result");
		System.out.println("Successfully switched to the current frame-->");

		//Instantiate Action Class 
		Actions actions = new Actions(driver); 

		//Retrieve WebElement 
		WebElement element = driver.findElement(By.xpath("//span[@class='tooltip-toggle']")); 

		// Use action class to mouse hover 
		actions.moveToElement(element).perform();
		
		actions.scrollToElement(element);
		
		actions.clickAndHold().moveToElement(element);                 
		actions.moveToElement(element).build().perform(); 

		//WebElement toolTip = driver.findElement(By.cssSelector("[class='tooltip-toggle']")); 
		//WebElement toolTip = driver.findElement(By.xpath("//span[@class='tooltip-toggle']")); 

		// To get the tool tip text and assert 
		String toolTipText = element.getText();
		System.out.println("toolTipText-->"+toolTipText); 

		//Verification if tooltip text is matching expected value 
		if(toolTipText.equalsIgnoreCase(RefMsg)){ 
			System.out.println("Pass* : Tooltip matching expected value");
		}else{
			System.out.println("Fail : Tooltip NOT matching expected value"); 
		} 

		// Close the main window 
		//driver.close();
		driver.quit();

	}

}
