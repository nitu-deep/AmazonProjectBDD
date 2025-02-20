package stepdefLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinationLogin extends Config {

	@Given("User is on the Amazon sign-in page by clicking on the URL")
	public void user_is_on_the_amazon_sign_in_page_by_clicking_on_the_url() {
		ConfigureBrowser();
	}
	
	@When("User enters the valid email")
	public void user_enters_the_valid_email() {
		driver.findElement(By.id("ap_email")).sendKeys(getProperty("email"));
	}
	
	@When("clicks the continue button")
	public void clicks_the_continue_button() {
		driver.findElement(By.id("continue")).click();
	}
	
	@When("enters the valid password")
	public void enters_the_valid_password() {
		driver.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
	}
	
	@When("clicks the sign-in button")
	public void clicks_the_sign_in_button() {
		driver.findElement(By.id("continue")).click();
	}
	
	@When("enters security question")
	public void enters_security_question() {
		// Wait for Window Security Popup to appear
        try {
            Thread.sleep(2000);  // Adjust sleep time if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
		try {
			Robot robot = new Robot();
	        // Enter password
	        String password = getProperty("pin");
	        for (char c : password.toCharArray()) {
	            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
	            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
	        }
	
	        // Press Enter to submit
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	
	    } catch (AWTException e) {
	        e.printStackTrace();
	    }
	}
	
	@Then("User should be redirected to the Amazon homepage")
	public void user_should_be_redirected_to_the_amazon_homepage() {
		String actualresult=driver.getCurrentUrl();
		System.out.println(actualresult);
	}
	
	
	
	@When("User enters an invalid email")
	public void user_enters_an_invalid_email() {
		driver.findElement(By.id("ap_email")).sendKeys("invalid.email@domain");
	}

	@When("clicks the invalid email continue button")
	public void clicks_the_invalid_email_continue_button() {
		driver.findElement(By.id("continue")).click();
	}
	
	@When("enters the invalid password") 
	public void enters_the_invalid_password() {
		driver.findElement(By.id("ap_password")).sendKeys("invalid");
	}
	
	@Then("The email ID field should display an error message and not accept the invalid value")
	public void the_email_id_field_should_display_an_error_message_and_not_accept_the_invalid_value() {
		System.out.println("Invalid email address");
		WebElement email_error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth-email-invalid-claim-alert")));
		System.out.println(email_error.isDisplayed());
	}
	
	@Then("User should be presented password error")
	public void User_should_be_presented_password_error() {
		System.out.println("Invalid password");
	}
		
	// Close the WebDriver after each scenario using the @After hook
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and clean up the WebDriver instance
        }
    }
}

