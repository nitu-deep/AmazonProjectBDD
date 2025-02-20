package stepdefLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config {
	WebDriver driver;
	WebDriverWait wait;
    private static Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/test/java/properties/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    
    public void ConfigureBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-agent=YourCustomUserAgent");
		driver=new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    driver.get(getProperty("url"));	
    }
}

