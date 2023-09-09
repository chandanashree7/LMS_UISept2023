package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = { "stepDefinition", "hooks" }, features = {
		"src/test/resources/features" }, dryRun = !true, plugin = { "pretty", "html:CucumberReports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:Reports/jsonReports.json",
				"junit:Reports/JunitReports.xml" })

public class testRunner extends AbstractTestNGCucumberTests {

}
