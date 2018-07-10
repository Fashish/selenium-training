package demos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// 1. Create WebDriver
		System.setProperty("webdriver.gecko.driver", "/Users/fash/Dev/WebDriver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		// implicit wait:
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 2. Navigate to the account management page >> Click on create account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
//		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		
		// 3. Fill out the form
			// How to locate elements:
			driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Bruce");
			driver.findElement(By.id("MainContent_txtEmail")).sendKeys("bwayne@test.com");
			driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("123456789");
			driver.findElement(By.cssSelector("#MainContent_txtPassword")).sendKeys("testpass");
			driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("testpass");
			
			// Radio button selection
			driver.findElement(By.id("MainContent_Male")).click();
			
			// Drop-down menu selection
			new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Croatia");
			
			// Check-box selection
			driver.findElement(By.name("ctl00$MainContent$checkUpdates")).click();
			
			driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		
		// 4. Get confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("CONFIRMATION: " + conf);
			
		// 5. Close browser 
		driver.close();
	}

}
