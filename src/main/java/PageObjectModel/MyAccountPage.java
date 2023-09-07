package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver1;

public class MyAccountPage extends AbstractClass{
	private static WebDriver driver;
	public MyAccountPage() {	
		driver = Driver1.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/ul/li[3]/a")
	WebElement myAddresses;
	public void clickOnMyAddresses(){
		clickFunction(myAddresses);
	}
	
}
