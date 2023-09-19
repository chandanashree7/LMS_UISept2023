package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class AttendencePage {

		
		
		@FindBy(linkText = "DashBoard")
		WebElement LoginDashBoard;
		
		//@When(Admin clicks "Attendance" on the navigation bar)
		
		@FindBy(linkText = "Attendance")
		WebElement Attendance;
		
		// Then("Admin should see the Manage attendance in header")
		
		@FindBy(tagName = "Manage Attendance")
		WebElement ManageAttendanceHeader;
		
		public AttendencePage() {
			
			PageFactory.initElements(driver,this);
		}
		public static WebDriver driver=DriverFactory.getdriver();
		String URL=ConfigReader.attendenceURL();
		
		public void attendenceURL() {

			driver.get(URL);

		}
		
		
		public void LoginDB() {
			LoginDashBoard.click();
		}
		public void AttendanceLink() {
			Attendance.click();	
		}
		public boolean isManageAttendanceHeaderDisplayed() {
	        return ManageAttendanceHeader.isDisplayed();
	    
		}
			
		}
		
		

