package spicejettest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpiceJetTest {

	WebDriver driver = new ChromeDriver();


	public void ScrollToVisibleElemt(WebElement element) {		
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.build().perform();
	}

	
	
	@Test
	public void spiceJetTest() throws Exception {

		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("(//*[@data-testid[1]='svg-img' and @height='8' and @preserveAspectRatio='none'])[1]"));
		if(element.isEnabled()) {
			ScrollToVisibleElemt(element);
			Thread.sleep(2000);
			element.click();			

			WebElement element1 = driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']"));
			ScrollToVisibleElemt(element1);
			Thread.sleep(2000);
			element1.click();
		}

		WebElement SrCitizenRadio = driver.findElement(By.xpath("//div[text() = 'Senior Citizen']//ancestor::*[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']/div[@class='css-1dbjc4n' and @style='margin-right: 6px;']//*[@data-testid='svg-img']"));

		if(!(SrCitizenRadio.isSelected())) {
			ScrollToVisibleElemt(SrCitizenRadio);
			SrCitizenRadio.click();			
			Assert.assertTrue(true, "Element is selected");
			System.out.println("Element is selected");
		}else {			
			Assert.assertTrue(false, "Element is not selected");
			System.out.println("Element is not selected");
		}
		
//		Thread.sleep(10000);
//		WebElement SrCitizenRadioSelected = driver.findElement(By.xpath("//div[text() = 'Senior Citizen']//ancestor::*[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']/div[@class='css-1dbjc4n' and @style='margin-right: 6px;']//*[@data-testid='svg-img']//*[@cx='9']"));
//		Thread.sleep(5000);
//		if(!(SrCitizenRadioSelected.isSelected())) {
//			Assert.assertTrue(false, "Element is not selected");
//		}else {			
//			Assert.assertTrue(true, "Element is selected");
//		}

		driver.quit();
	}
}
