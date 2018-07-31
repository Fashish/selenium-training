package stepImplementaions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BDDLoginTest {
	WebDriver driver;
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		driver = utilities.DriverFactory.open("Chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");	
	}
	
//    @When("^user enters correct username and correct password$")
//	public void user_enters_correct_username_and_correct_password() {
//		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
//		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("pass");
//		driver.findElement(By.id("MainContent_btnLogin")).click();
//	}
    
  	@When("^user enters email (.*)$")
  	public void user_enters_username(String username) {
  		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
  	}

  	@And("^user enters password (.*)$")
  	public void user_enters_password(String password) {
  		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
  	}
	
  	@And("^user clicks submit$")
  	public void user_clicks_submit() {
  		driver.findElement(By.id("MainContent_btnLogin")).click();
  	}
  	
    @Then("^user gets confirmation$")
    public void user_gets_confirmation() {
    	String confMessage = driver.findElement(By.id("conf_message")).getText();
    	Assert.assertTrue(confMessage.contains("success"));
    }
    
    @After
    public void tearDown() {
    	driver.quit();
    }
}
