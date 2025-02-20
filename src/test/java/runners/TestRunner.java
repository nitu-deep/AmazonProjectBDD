package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/feature",  // Path to your feature files
    glue = "stepdefLogin",                  // Path to your step definitions
    plugin = {
        "pretty",                              // Console output
        "html:target/cucumber-reports.html",    // HTML report at target folder
        "json:target/cucumber-reports/cucumber.json", // JSON report for integration with other tools
        "junit:target/cucumber-reports/cucumber.xml" // JUnit XML report
    }
)
public class TestRunner {
    // This class is used to run the tests
}

