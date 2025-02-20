package stepdefLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinitionSearch extends Config {

	@Given("Search_User is on the Amazon sign-in page by clicking on the URL")
	public void yourorder_user_is_on_the_amazon_sign_in_page_by_clicking_on_the_url() {
		ConfigureBrowser();
	}
	
	@When("Search_User enters the valid email")
	public void your_address_user_enters_the_valid_email() {
	    driver.findElement(By.id("ap_email")).sendKeys(getProperty("email"));
	}

	@When("Search_User clicks the continue button")
	public void your_address_clicks_the_continue_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("Search_User enters the valid password")
	public void your_address_enters_the_valid_password() {
		driver.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
	}

	@When("Search_User clicks the sign-in button")
	public void your_address_clicks_the_sign_in_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("Search_User enters security question")
	public void your_address_enters_security_question() {
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

	
	@When("Search_User Enter the data in Search Textbox")
	public void enter_the_data_in_search_textbox() {
	    WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
	    search.sendKeys("T-Shirt");
	}

	@When("Search_User Click search button")
	public void click_search_button() {
	    WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
	    searchBtn.click();
	}

	@Then("Display list of items")
	public void display_list_of_items() {
	    System.out.println(driver.getTitle());
	    Assert.assertEquals("Amazon.ca : T-Shirt", driver.getTitle());
	}
	
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and clean up the WebDriver instance
        }
    }
}
