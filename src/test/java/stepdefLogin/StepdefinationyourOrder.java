package stepdefLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinationyourOrder extends Config {

	@Given("Yourorder_User is on the Amazon sign-in page by clicking on the URL")
	public void yourorder_user_is_on_the_amazon_sign_in_page_by_clicking_on_the_url() {
		ConfigureBrowser();
	}
	
	@When("Yourorder_User enters the valid email")
	public void yourorder_user_enters_the_valid_email() {
		driver.findElement(By.id("ap_email")).sendKeys(getProperty("email"));
	}

	@When("Yourorder_clicks the continue button")
	public void yourorder_clicks_the_continue_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("Yourorder_enters the valid password")
	public void yourorder_enters_the_valid_password() {
		driver.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
	}

	@When("Yourorder_clicks the sign-in button")
	public void yourorder_clicks_the_sign_in_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("Yourorder_enters security question")
	public void yourorder_enters_security_question() {
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

	@When("Yourorder_mousehover to Account and list")
	public void yourorder_mousehover_to_account_and_list() {
		WebElement account_list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		Actions action=new Actions(driver);
		action.moveToElement(account_list).build().perform();
	}

	@When("Yourorder_Click on Your Account")
	public void yourorder_click_on_your_account() {
		driver.findElement(By.linkText("Your Account")).click();
	}

	@When("Yourorder_Clck on Your order")
	public void yourorder_clck_on_your_order() {
		driver.findElement(By.className("ya-card__whole-card-link")).click();
	}

	@Then("Shows different options")
	public void shows_different_options() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Your Orders");
	}
	@When("Yourorder_Cllick on Buyagain")
	public void yourorder_cllick_on_buyagain() {
	    driver.findElement(By.linkText("Buy Again")).click();
	}
	@When("Yourorder_Cllick on NotyetShipped")
	public void yourorder_cllick_on_notyet_shipped() {
		driver.findElement(By.linkText("Not Yet Shipped")).click();
	}

	@When("Yourorder_Cancelled orders")
	public void yourorder_cancelled_orders() {
		driver.findElement(By.linkText("Cancelled Orders")).click();
	}
	@Then("Shows Buy again options")
	public void shows_buy_again_options() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Buy Again");
	}
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and clean up the WebDriver instance
        }
    }
}

