package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.cff.driver.DriverManager;

public class CommonFunctions {
	
	WebDriver driver = new ChromeDriver();

	public static void ScrollToVisibleElement(WebElement elem) {

		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(elem);
		actions.build().perform();
	}
}
