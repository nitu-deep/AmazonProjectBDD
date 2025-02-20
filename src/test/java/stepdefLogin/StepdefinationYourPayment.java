package stepdefLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

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

public class StepdefinationYourPayment extends Config {
	List<WebElement> cardELements;
    String Select;
	@Given("YourPayment_User is on the Amazon sign-in page by clicking on the URL")
	public void your_payment_user_is_on_the_amazon_sign_in_page_by_clicking_on_the_url() {
		ConfigureBrowser();
	}

	@When("YourPayment_User enters the valid email")
	public void your_payment_user_enters_the_valid_email() {
		driver.findElement(By.id("ap_email")).sendKeys(getProperty("email"));
	}

	@When("YourPayment_clicks the continue button")
	public void your_payment_clicks_the_continue_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("YourPayment_enters the valid password")
	public void your_payment_enters_the_valid_password() {
		driver.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
	}

	@When("YourPayment_clicks the sign-in button")
	public void your_payment_clicks_the_sign_in_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("YourPayment_enters security question")
	public void your_payment_enters_security_question() {
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
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	
	    } catch (AWTException e) {
	        e.printStackTrace();
	    }
	}
	

	@When("YourPayment_mousehover to Account and list")
	public void your_payment_mousehover_to_account_and_list() {
		WebElement account_list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		Actions action=new Actions(driver);
		action.moveToElement(account_list).build().perform();
	}

	@When("YourPayment_Clcik on YourAccount")
	public void your_payment_clcik_on_your_account() {
		driver.findElement(By.linkText("Your Account")).click();
	}

	@When("YourPayment_Click on YourPayments")
	public void your_payment_click_on_your_payments() {
		List<WebElement> YourAccounts_Items = driver.findElements(By.className("ya-card__whole-card-link"));
		WebElement Payment = YourAccounts_Items.get(5);
		Payment.click();
	}

	@When("YourPayment_Click on Add the payment method")
	public void your_payment_click_on_add_the_payment_method() {
	    driver.findElement(By.linkText("Add a payment method")).click();
	}

	@When("YourPayment_Click on Add debit or credit card")
	public void your_payment_click_on_add_debit_or_credit_card() {
		WebElement addCardButton = wait.until(ExpectedConditions.refreshed(
		   ExpectedConditions.presenceOfElementLocated(By.id("apx-add-credit-card-action-test-id"))
		));
		addCardButton.click();
	}

	@When("YourPayment_Enter Credit Card number")
	public void your_payment_enter_credit_card_number() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
		driver.switchTo().frame(iframe);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dialog = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']")));
		dialog.isDisplayed();
		cardELements = driver.findElements(By.className("css-11aywtz"));
		cardELements.get(0).sendKeys("5123456789012346");
	}

	@When("YourPayment_Enter expiry date")
	public void your_payment_enter_expiry_date() {
		cardELements.get(1).sendKeys("0534");
	}

	@When("YourPayment_Enter security Code")
	public void your_payment_enter_security_code() {
		cardELements.get(2).sendKeys("100");
	}

	@When("YourPayment_Name on the Card")
	public void your_payment_name_on_the_card() {
		cardELements.get(3).sendKeys("Test Card");
	}

	@When("YourPayment_Click on Add and Continue")
	public void your_payment_click_on_add_and_continue() {
		WebElement btn = driver.findElement(By.className("css-18t94o4"));
		btn.click();
		//driver.switchTo().defaultContent();
	}

	@Then("Select Card")
	public void select_card() {
		driver.switchTo().defaultContent();
		System.out.println("Payment method added");
	}

	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and clean up the WebDriver instance
        }
    }

}
