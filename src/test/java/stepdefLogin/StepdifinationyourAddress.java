package stepdefLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdifinationyourAddress extends Config {
    String Select;
	
    @Given("YourAddress_User is on the Amazon sign-in page by clicking on the URL")
	public void your_address_user_is_on_the_amazon_sign_in_page_by_clicking_on_the_url() {
    	ConfigureBrowser();
	}

	@When("YourAddress_User enters the valid email")
	public void your_address_user_enters_the_valid_email() {
	    driver.findElement(By.id("ap_email")).sendKeys(getProperty("email"));
	}

	@When("YourAddress_clicks the continue button")
	public void your_address_clicks_the_continue_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("YourAddress_enters the valid password")
	public void your_address_enters_the_valid_password() {
		driver.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
	}

	@When("YourAddress_clicks the sign-in button")
	public void your_address_clicks_the_sign_in_button() {
		driver.findElement(By.id("continue")).click();
	}

	@When("YourAddress_enters security question")
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
	
	@When("YourAddress_mousehover to Account and list")
	public void your_address_mousehover_to_account_and_list() {
		WebElement account_list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		Actions action=new Actions(driver);
		action.moveToElement(account_list).build().perform();
	}

	@When("YourAddress_Click on YourAccount")
	public void show_all_the_my_account_options() {
	    driver.findElement(By.linkText("Your Account")).click();

	}
	@When("YourAddress_Click on YourAdress")
	public void your_address_click_on_your_adress() {
		//@FindBy(className="ya-card__whole-card-link")
		List<WebElement> YourAccounts_Items = driver.findElements(By.className("ya-card__whole-card-link"));
		WebElement Address = YourAccounts_Items.get(3);
		Address.click();
		
	}

	@When("YourAddress_Click on AddAddress")
	public void your_address_click_on_add_address() {
		driver.findElement(By.className("add-new-address-button")).click();
		
	}

	@When("YourAddress_Enter FirstandLastName")
	public void your_address_enter_firstand_last_name() {
		WebElement FullName=driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
		FullName.sendKeys("Kajal Sharma");
	}

	@When("YourAddress_Enter Phonenumber")
	public void your_address_enter_phonenumber() {
		WebElement Phone=driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));
		Phone.sendKeys("6477211834");
	}

	@When("YourAddress_Enter Address")
	public void your_address_enter_address() {
		WebElement Address=driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
		Address.sendKeys("740 Darcel");
	}

	@When("YourAddress_Enter City")
	public void your_address_enter_city() {
		WebElement City=driver.findElement(By.id("address-ui-widgets-enterAddressCity"));
		City.sendKeys("Mississauga");
	}

	@When("YourAddress_Enter Postal code")
	public void your_address_enter_postal_code() {
		WebElement Postal=driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode"));
		Postal.sendKeys("K7F1J9");
	}
	
	@When("YourAddress_Enter Province")
	public void your_address_enter_province() {
		WebElement Province = driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId"));
		Select select = new Select(Province);
        // Select an option by visible text
        select.selectByVisibleText("Ontario");
        // Click on a specific option by visible text (e.g., "Option Text")
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals("Ontario")) {
            	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Ontario")));
            	button.click();
                break;
            }
        }        
	}

	@When("YourAddress_Click on Add Address button")
	public void your_address_click_on_add_address_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("address-ui-widgets-form-submit-button")));
		button.click();
	}
	
	@Then("Show Address")
	public void show_address() {
	    WebElement span = driver.findElement(By.xpath("//span[contains(text(),'Original Address:')]"));
		Assert.assertEquals(span.isDisplayed(), true);
	}
	
	
	@Then("Show FullName_Error")
	public void your_address_error_empty_fullname() {
		WebElement fullName = driver.findElement(By.xpath("//div[text()='Please enter a name.']"));
	    System.out.println("Full Name Error: " + fullName.getText());
	}
	
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and clean up the WebDriver instance
        }
    }
}
