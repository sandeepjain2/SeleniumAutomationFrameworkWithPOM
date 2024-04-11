package temp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Temp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		
		//august 24
		
		driver.findElement(By.xpath("//div[.='Departure Date']")).click(); 
		
		//driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[1]")).click();
	    
	    List <WebElement> monthAndYear = driver.findElements(By.xpath("//div[contains(@class,'css-76zvg2 r-homxoj r-adyw6z r-1kfrs79')]"));
	    System.out.println("Size is : " + monthAndYear.size());
	    
	    for (int i = 0; i < monthAndYear.size(); i++) {
	    	
	    	String monthyear = monthAndYear.get(i).getText();
		    System.out.println(monthyear);
		    
		    String month = monthyear.split(" ")[0].trim();
		    System.out.println(month);
		    String year = monthyear.split(" ")[1].trim();
		    System.out.println(year);
		    
		    if (month.equalsIgnoreCase("November") && year.equalsIgnoreCase("2023")) {
		    	
		    	//-----------grab common attribute in calender dates and put it into list -------
	    		List<WebElement> dates =driver.findElements(By.xpath("//div[contains(@data-testid,'undefined-month')]//div[contains(@data-testid,'undefined-calendar-day')]"));
	    		
	    		int count  = dates.size();
	    		
	    		System.out.println(count);
	    		
	    		for(int j=0; j<count; j++)
	    		{
	    			String dateText = dates.get(j).getText();
	    			
	    			if(dateText.equalsIgnoreCase("24"))
	    			{
	    				dates.get(j).click();
	    				
	    				break;
	    			}
	    		}
	    		
	    		String dateSelected = driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']/div/div[1]")).getText(); 
	    		
	    		System.out.println(dateSelected); 
		    	
		    } else {		    	
		    	continue;		    	
		    }
	    	
	    }	    
	    
	    driver.quit();
	    
	    /*
	    int counter = 1;
	    
	    while (counter <= 13) {
	    	
	    	if (!(month.equalsIgnoreCase("November") && year.equalsIgnoreCase("2023"))) {
	    		
//	    		driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[1]")).click();
//				Thread.sleep(2000);
	    		driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 r-homxoj r-adyw6z r-1kfrs79')]")).click();
				monthyear = driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 r-homxoj r-adyw6z r-1kfrs79')]")).getText();
			    System.out.println(monthyear);	
			    
			    month = monthyear.split(" ")[0].trim();
			    year = monthyear.split(" ")[1].trim();
			    
	    		counter++;
	    		
	    		System.out.println(counter);
	    		
	    	} else {
	    		//-----------grab common attribute in calender dates and put it into list -------
	    		List<WebElement> dates =driver.findElements(By.xpath("//div[contains(@data-testid,'undefined-month')]//div[contains(@data-testid,'undefined-calendar-day')]"));
	    		
	    		int count  = dates.size();
	    		
	    		System.out.println(count);
	    		
	    		for(int i=0; i<count;i++)
	    		{
	    			String dateText = dates.get(i).getText();
	    			
	    			if(dateText.equalsIgnoreCase("24"))
	    			{
	    				dates.get(i).click();
	    				
	    				break;
	    			}
	    		}
	    		
	    		String dateSelected = driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']/div/div[1]")).getText(); 
	    		
	    		System.out.println(dateSelected); 
	    		
	    	}
	    }
	    */
	    
	    
//		while (!(month.equalsIgnoreCase("November") && year.equalsIgnoreCase("2023")))
//		{
//			driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[1]")).click();
//			Thread.sleep(2000);
//			
//			driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 r-homxoj r-adyw6z r-1kfrs79')]")).click();
//			monthyear = driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 r-homxoj r-adyw6z r-1kfrs79')]")).getText();
//		    System.out.println(monthyear);	
//		    
//		    month = monthyear.split(" ")[0].trim();
//		    year = monthyear.split(" ")[1].trim();
//		}
		
		
		
		

	}

}

