package hooks;

import java.io.ByteArrayInputStream;
import java.util.ResourceBundle;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import driverFactory.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
//import utilities.ConfigReader;

public class Hooks {

	private WebDriver driver;
	private DriverFactory driverfactory;
	static Scenario scenario;
	public static ResourceBundle rb;
	public static String browser;

	@BeforeAll
	public  void before() throws Throwable {
		// Get browser Type from config file
		System.out.println("Loading Config file");
		//ConfigReader.loadConfig();
		//String browser = ConfigReader.getBrowserType();
		rb = ResourceBundle.getBundle("config");
		browser = rb.getString("browser");
		// Initialize driver from driver factory
		driverfactory = new DriverFactory();
		driver = driverfactory.initializeDrivers(browser);
		System.out.println("Initializing driver for : " + browser);

	}

	@Before
	public void scenario(Scenario scenario) {
		System.out.println(
				"===============================================================================================");
		System.out.println(scenario.getSourceTagNames() + " : " + scenario.getName());
		System.out.println(
				"-----------------------------------------------------------------------------------------------");

	}

	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			System.out.println("Steps Failed , Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}
	}

	@AfterAll
	public void after() {
		System.out.println("Closing Driver");
		driverfactory.closeallDriver();
	}

}
