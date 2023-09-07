package PageObjectModel;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver1;

public class MainPage extends AbstractClass{
	private static WebDriver driver;
	public MainPage() {	
		driver = Driver1.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className =  "login")
	private WebElement loginButton;
	
	public void clickLoginButton(){		
		clickFunction(loginButton);
	}
	
	
}
