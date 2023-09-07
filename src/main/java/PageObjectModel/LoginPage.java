package PageObjectModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver1;

public class LoginPage extends AbstractClass{
	private static WebDriver driver;
	public static String email = "Girilmedi";
	public static String password = "Girilmedi";
	public LoginPage() {
		driver = Driver1.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	WebElement emailBox;
	
	public void typeEmail() throws FileNotFoundException {
		getCredentials();
		sendKeys(emailBox, email);	
	}
	
	@FindBy(id = "passwd")
	WebElement passwordBox;
	public void typePassword() {
		
		sendKeys(passwordBox, password);
	}
	
	@FindBy(id = "SubmitLogin")
	WebElement loginButton;
	public void clickOnSubmitButton() {
		clickFunction(loginButton);
	}
	public static void getCredentials() throws FileNotFoundException {
		String filePath = "C:\\Users\\Egemen\\eclipse-workspace\\Cucumber_proje\\src\\main\\java\\utilities\\login.txt";
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		email = scanner.next();
		password = scanner.next();
		scanner.close();
		
	}
	
}
