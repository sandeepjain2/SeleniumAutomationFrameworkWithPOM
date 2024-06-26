package com.tooltip.testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;  


public class JqueryToolTip {                
	public static void main(String[] args) {                                    

		String baseUrl = "http://demo.guru99.com/test/tooltip.html";                    
		System.setProperty("webdriver.chrome.driver", "E:\\Dependency\\Driver\\chromedriver.exe");   

		WebDriver driver = new ChromeDriver();                  
		String expectedTooltip = "What's new in 3.2";                   
		driver.get(baseUrl);
		
		//Maximise browser window 
		driver.manage().window().maximize();

		WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));                         
		Actions builder = new Actions (driver);                         

		builder.clickAndHold().moveToElement(download);                 
		builder.moveToElement(download).build().perform();  

		WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));                           
		String actualTooltip = toolTipElement.getText();            

		System.out.println("Actual Title of Tool Tip Is --> "+actualTooltip);                         
		if(actualTooltip.equals(expectedTooltip)) {                         
			System.out.println("Test Case Passed");                 
		}       
		driver.close();         
	}        
}