package allytesting;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.deque.html.axecore.args.AxeRules;
import com.deque.html.axecore.results.AxeResults;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;


public class AllyAutomationTest {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void amazonAllyTest() {
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

		Results responseJSON = new AxeBuilder().analyze(driver);
		List<com.deque.html.axecore.results.Rule> violationList = responseJSON.getViolations();
		System.out.println(violationList);
		
		Gson gson = new Gson();
		JsonArray jsonArray = gson.toJsonTree(violationList).getAsJsonArray();
		
		System.out.println(jsonArray);
		
		
		if(jsonArray.size() == 0) {
			System.out.println("No Errors!!!");
			
		} else {
			AxeReporter.writeResultsToJsonFile("amazonAllyTest", responseJSON);
		}

		
//		if(violationList.size() == 0) {
//			System.out.println("No Errors!!!");
//			
//		} else {
//			System.out.println("Errors are there");
//			AxeReporter.getReadableAxeResults("amazonAllyTest", driver, violationList);
//			Assert.assertTrue(true);
//		}
		
		driver.quit();

	}
	
}
