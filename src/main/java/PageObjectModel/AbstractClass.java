package PageObjectModel;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver1;


public abstract class AbstractClass {
      	
	private WebDriver driver = Driver1.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public void clickFunction (WebElement clickElement) {
		
		wait.until(ExpectedConditions.elementToBeClickable(clickElement));
		
		clickElement.click();
		
	}
	
	public void sendKeys(WebElement sendKeysElement, String value) {
		
		wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
		
		sendKeysElement.sendKeys(value);
		
	}
	
	public void selectElementFromDropdown(WebElement dropdown,String element) {
		
		Select slc =new Select(dropdown);		
		slc.selectByVisibleText(element);
		
	}
	
	public void Assertion(WebElement actual,String expected) {
		
		wait.until(ExpectedConditions.visibilityOf(actual));
	Assert.assertEquals(actual.getText(), expected);
	System.out.println("My message: " +actual.getText());
	}

}
