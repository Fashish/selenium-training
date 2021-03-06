package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// 1. Define the web browser
		System.setProperty("Webdriver.chrome.driver", "/Users/fash/Dev/WebDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		// 2. Open web browser and navigate to page 
		// http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

		// 3. Enter email address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		
		// 4. Enter password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		
		// 5. Click login
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		// 6. Get confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + message);

		// 7.Close the browser
		driver.close();
	}

}
