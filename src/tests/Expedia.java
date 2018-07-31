package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	
	WebDriver driver;
	String browserType = "Chrome";
	String city = "New York, NY";
	String checkIn = "08/03/2018";
	String checkOut = "08/10/2018";
	String numOfGuests = "2";
	String searchResult = "3";
	
	
	@Test
	public void hotelReservation() {
		// 1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();;
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();;
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button")).click();
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div/div[2]/div[4]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/footer/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[10]/label/button")).click();
		
		// Print the name of the city
		String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println("CITY: " + actualCity);
		
		// 2. Modify the search results page, give criteria
		driver.findElement(By.cssSelector("input[name='star'][id='star4']")).click();
		
		// 3. Analyse the results and make our selection
		driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();
		
		// Switch the window to the pop-up
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		// 4. Book reservation
		
		
		// 5. Fill out contact / billing
		
		// 6. Get confirmation
	}
	
	@BeforeMethod
	public void setUP() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}

}
