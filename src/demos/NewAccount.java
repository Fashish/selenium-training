package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String name = "Bruce";
		String email = "bwayne@test.com";
		String password = "testpass";
		String country = "Croatia";
		String phoneNumber = "123456789";
		String browserType = "chrome";
		String gender = "Female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occasionalEmail = true;
		
		// Define WebDriver
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		
		// Define web elements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordElement = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
		WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		WebElement monthlyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
		WebElement occasionalCheckbox = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
		
		
		// Fill out the form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
			
		// Gender radio button algorithm
		if (gender.equalsIgnoreCase("Male")) {
			maleRadio.click();
		}
		else {
			femaleRadio.click();
		}
		
		
		// Check box algorithm
		if (weeklyEmail) {
			if (!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		else if (weeklyEmail == false) {
			if (weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		
		if (monthlyEmail) {
			if (!monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
		}
		else if (monthlyEmail == false) {
			if (monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
		}
		
		if (occasionalEmail) {
			if (!occasionalCheckbox.isSelected()) {
				occasionalCheckbox.click();
			}
		}
		else if (occasionalEmail == false) {
			if (occasionalCheckbox.isSelected()) {
				occasionalCheckbox.click();
			}
		}
		
		driver.findElement(By.id("MainContent_btnSubmit")).click();
					
		// 4. Get confirmation & close browser
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("CONFIRMATION: " + conf);
		driver.close();
	}

}
