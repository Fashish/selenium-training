package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	
	@Test
	public void loginTestPOM() {
		
		// 1. Initialize driver
		WebDriver driver = utilities.DriverFactory.open("Firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 2. Enter loging information (login page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("tim@testemail.com");
		loginPage.setPassword("pass");
		loginPage.clickSubmit();
		
		// 3. Get confirmation (Dashboard page)
		DashboardPage dashboard = new DashboardPage(driver);
		String conf = dashboard.confirmationMessage();
		String title = dashboard.title();
		
		// 4. Assertions
		Assert.assertTrue(conf.contains("successfully"));
		Assert.assertTrue(title.contains("Account"));
		
		// 5. Close the driver
		driver.quit();
	}

}
