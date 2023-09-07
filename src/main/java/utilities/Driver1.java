package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import stepDefinition.Hooks;

public class Driver1 {
private static WebDriver driver;

public static WebDriver getDriver() {
	if(Hooks.headless.equals("true")&&Hooks.browser.equals("firefox"))
	{
		System.out.println("headless");
		if(driver ==null) {
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("--headless"); 
			driver = new FirefoxDriver(options);
		}
	}else if(Hooks.browser.equals("firefox")&&Hooks.headless.equals("false")){
		System.out.println("head");
		if(driver ==null) {
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");		
		driver = new FirefoxDriver();
	}
	}	if(Hooks.headless.equals("true")&&Hooks.browser.equals("Edge"))
	{
		System.out.println("headless");
		if(driver ==null) {
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			EdgeOptions options = new EdgeOptions();
	        options.addArguments("--headless"); 
			driver = new EdgeDriver(options);
		}
	}else if(Hooks.browser.equals("Edge")&&Hooks.headless.equals("false")){
		System.out.println("head");
		if(driver ==null) {
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");		
		driver = new EdgeDriver();
	}
	}
	
	return driver;
}


public static WebDriver getHeadlessDriver() {	
	if(driver ==null) {
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); // Headless modu etkinleştir
		driver = new FirefoxDriver(options);
	}
	return driver;
}


public static void closeDriver() {
	if(driver!=null) {
		driver.quit();
		driver=null;
	}
}

}