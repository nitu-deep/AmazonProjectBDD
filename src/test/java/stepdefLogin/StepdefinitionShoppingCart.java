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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinitionShoppingCart extends Config {
    String Select;
	
    @Given("Shopping_Cart_User is on the Amazon sign-in page by clicking on the URL")
	public void shopping_cart_user_is_on_the_amazon_sign_in_page_by_clicking_on_the_url() {
    	ConfigureBrowser();
	}

	@When("Shopping_Cart_User enters the valid email")
	public void shopping_cart_user_enters_the_valid_email() {
	    driver.findElement(By.id("ap_email")).sendKeys(getProperty("email"));
	}

	@When("Shopping_Cart_User click the continue button")
	public void shopping_cart_user_click_the_continue_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("Shopping_Cart_User enter the valid password")
	public void shopping_cart_user_enter_the_valid_password() {
		driver.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
	}

	@When("Shopping_Cart_User click the sign-in button")
	public void shopping_cart_user_click_the_sign_in_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("Shopping_Cart_User enter security question")
	public void shopping_cart_user_enter_security_question() {
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
	
	@When("Shopping_Cart_User click on Cart Icon")
	public void show_all_the_my_account_options() {
		WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart")));
	    cart.click();
	}
	
	@Then("Lands on Shopping Cart Page")
	public void Lands_on_Shopping_Cart_Page() {
	    System.out.println(driver.getTitle() + "==Amazon.ca Shopping Cart");
	}
	
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and clean up the WebDriver instance
        }
    }
}
