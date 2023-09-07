package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import utilities.Driver1;

public class MyAddressesPage extends AbstractClass{
		WebDriver driver;
	public MyAddressesPage() {
		driver = Driver1.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/a")
	WebElement addAddressButton;
	
	public void clickOnAddAddressButton() {
		clickFunction(addAddressButton);
	}
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p")
	WebElement text;
	
	public void assertText() {
		Assertion(text, "Please configure your default billing and delivery addresses when placing an order. You may also add additional addresses, which can be useful for sending gifts or receiving an order at your office.");
	}
	
	
}
