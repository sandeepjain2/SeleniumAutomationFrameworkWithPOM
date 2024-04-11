package allytesting;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AllyTestingUsingDriverManager {
	
WebDriver driver = new ChromeDriver();
	
	@Test
	public void amazonAllyTest() throws Exception {
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Load the Tenon-IO script
		String script = "var script = document.createElement('script');"
		        + "script.src = 'https://www.tenon.io/scripts/tenon-api.js';"
		        + "script.type = 'text/javascript';"
		        + "document.getElementsByTagName('head')[0].appendChild(script);";

		jsExecutor.executeScript(script);

		// Wait for the script to load
		Thread.sleep(2000);  // Adjust the waiting time if needed
		
		// Wait until the script is loaded
		jsExecutor.executeScript("return document.readyState").equals("complete");

		// Run the accessibility test
		String results = (String) jsExecutor.executeScript(
		        "return tenonApi.analyze(document.documentElement.outerHTML);"
		);

		// Parse the JSON response
		JSONObject jsonResponse = new JSONObject(results);
		JSONArray issues = jsonResponse.getJSONArray("resultSet");

		if (issues.length() > 0) {
		    System.out.println("Accessibility violations found:");
		    for (int i = 0; i < issues.length(); i++) {
		        JSONObject issue = issues.getJSONObject(i);
		        String errorTitle = issue.getString("errorTitle");
		        String errorSnippet = issue.getString("errorSnippet");
		        System.out.println("Error: " + errorTitle);
		        System.out.println("Snippet: " + errorSnippet);
		        System.out.println();
		    }
		} else {
		    System.out.println("No accessibility violations found.");
		}


		
		driver.quit();

	}

}
