package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	// This method will return a WebDriver object
	public static WebDriver open(String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/fash/Dev/WebDriver/geckodriver");
			return new FirefoxDriver();
		}
		else {
			System.setProperty("Webdriver.chrome.driver", "/Users/fash/Dev/WebDriver/chromedriver");
			return new ChromeDriver();
		}
	}
}
