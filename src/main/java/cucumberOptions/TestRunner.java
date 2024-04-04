package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features",monochrome = true
        ,tags = "@Test"
,glue = "stepDefinitions",
        plugin = "json:target/jsonReports/cucumber-report.json")

public class TestRunner extends AbstractTestNGCucumberTests {
}
