package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageFactory {
	WebDriver driver;
	
	@FindBy(id="conf_message")
	WebElement confirmationMessageText;
	
	@FindBy(linkText="Change password")
	WebElement changePasswordLink;
	
	// Steps
	
	public String confirmationMessage() {
		return confirmationMessageText.getText();
	}
	
	public String title() {
		return driver.getTitle();
	}
	
	public void changePassword() {
		changePasswordLink.click();
	}
	
	// Actions
	
	public void confirm() {
		confirmationMessage();
		changePassword();
		title();
	}
	
	public DashboardPageFactory(WebDriver driver) {
		this.driver = driver;
	}
}
