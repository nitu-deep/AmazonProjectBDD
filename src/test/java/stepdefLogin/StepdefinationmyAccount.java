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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinationmyAccount extends Config {

	@Given("MyAccount_User is on the Amazon sign-in page by clicking on the URL")
	public void my_account_user_is_on_the_amazon_sign_in_page_by_clicking_on_the_url() {
		ConfigureBrowser();
	}
	

	@When("MyAccount_User enters the valid email")
	public void my_account_user_enters_the_valid_email() {
		driver.findElement(By.id("ap_email")).sendKeys(getProperty("email"));
	}

	@When("MyAccount_clicks the continue button")
	public void my_account_clicks_the_continue_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("MyAccount_enters the valid password")
	public void my_account_enters_the_valid_password() {
		driver.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
	}

	@When("MyAccount_clicks the sign-in button")
	public void my_account_clicks_the_sign_in_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("MyAccount_enters security question")
	public void my_account_enters_security_question() {
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
	
	@When("MyAccount_mousehover to Account and list")
	public void my_account_mousehover_to_account_and_list() {
		WebElement account_list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		Actions action=new Actions(driver);
		action.moveToElement(account_list).build().perform();
	}

	@Then("Click on YourAccount")
	public void show_all_the_my_account_options() {
	    driver.findElement(By.linkText("Your Account")).click();
	}
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and clean up the WebDriver instance
        }
    }
}
