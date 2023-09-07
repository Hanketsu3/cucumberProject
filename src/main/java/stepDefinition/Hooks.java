package stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import utilities.Driver1;
public class Hooks {
	WebDriver driver;
	public static String headless ="false";
	public static String browser = "firefox";
	
	
	@Before
	public void beforeScenerio(Scenario scenario) {
		headless = "false";
		browser = "firefox";
		String scenarioName= scenario.getName();
		if(scenarioName.contains("Headless")) {
			headless="true";
		}
		if(scenarioName.contains("Edge")) {
			browser="Edge";
		}
		driver = Driver1.getDriver();
	}
	@Step("Failure screenshot")
	@After
	public void screenshot(Scenario scenario) {
		if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failure-screenshot");
           Allure.addByteAttachmentAsync("Failed", "img/png",".png", ()->screenshot);
        }
		
	}
	@After(order=0)
    public void afterScenario() {	
		driver = Driver1.getDriver();
        if (driver != null) {
            Driver1.closeDriver();
        }      
    }

	
	
	
	
	
	

}
