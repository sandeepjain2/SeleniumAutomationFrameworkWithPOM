package spicejettest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cff.driver.DriverManager;
import com.cff.tests.BaseTests;

import commons.CommonFunctions;

public class SpiceJetTest1 extends BaseTests{
	
	private SpiceJetTest1() {
		
	}

	@Test
	public void spiceJetTest() {

		WebElement element = DriverManager.getDriver().findElement(By.xpath("(//*[@data-testid[1]='svg-img' and @height='8' and @preserveAspectRatio='none'])[1]"));
		if(element.isEnabled()) {
			CommonFunctions.ScrollToVisibleElement(element);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			element.click();			

			WebElement element1 = DriverManager.getDriver().findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']"));
			CommonFunctions.ScrollToVisibleElement(element1);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			element1.click();
		}

		WebElement SrCitizenRadio = DriverManager.getDriver().findElement(By.xpath("//div[text() = 'Senior Citizen']//ancestor::*[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']/div[@class='css-1dbjc4n' and @style='margin-right: 6px;']//*[@data-testid='svg-img']"));

		if(!(SrCitizenRadio.isSelected())) {
			CommonFunctions.ScrollToVisibleElement(SrCitizenRadio);
			SrCitizenRadio.click();			
			Assert.assertTrue(true, "Element is selected");
			System.out.println("Element is selected");
		}else {			
			Assert.assertTrue(false, "Element is not selected");
			System.out.println("Element is not selected");
		}
	}
}
