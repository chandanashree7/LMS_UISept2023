package runner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(glue ={"stepDefinitions", "hooks"},
				features = {"src/test/resources/features" }, 
				dryRun =!true, 
				monochrome=true,
				plugin = { "pretty", "html:CucumberReports.html",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"json:Reports/jsonReports.json",
						"junit:Reports/JunitReports.xml" })

public class testRunner extends AbstractTestNGCucumberTests {

}
