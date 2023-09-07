package PageObjectModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver1;

public class YourAddressesPage extends AbstractClass{
	WebDriver driver;
	public YourAddressesPage() {
		driver = Driver1.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "address1")
	WebElement address;
	
	public void typeAddress(String addressN) {
		sendKeys(address, addressN);
	}
	
	@FindBy(id = "city")
	WebElement city;
	public void typeCity() {
		sendKeys(city, "city");
	}
	
	@FindBy(id = "id_state")
	WebElement state;
	
	public void slcState() {
		selectElementFromDropdown(state, "Florida");
	}
	@FindBy(id = "postcode")
	WebElement postcode;
	public void typePostCode() {
		sendKeys(postcode,"35000");
	}
	@FindBy(id = "phone")
	WebElement phone;
	public void typePhone() {
		sendKeys(phone, "05051517053");
	}
	@FindBy(id = "submitAddress")
	WebElement saveButton;
	public void clickOnSave() {
		clickFunction(saveButton);
	}
	@FindBy(id = "alias")
	WebElement alias;
	public void typeAddressName() throws FileNotFoundException  {
	
		Random rn = new Random();
		String filePath = "C:\\Users\\Egemen\\eclipse-workspace\\Cucumber_proje\\src\\main\\java\\utilities\\increment.txt";
		int num = getNumber(filePath);
		sendKeys(alias, " "+(num+rn.nextInt(10)));
		overwriteFileContent(filePath, ""+(num+1));
	
	}
	
	public static int getNumber(String filePath) throws FileNotFoundException {
		File increment = new File(filePath);
		Scanner scanner = new Scanner(increment);
		int num = scanner.nextInt();
		scanner.close();
		return num;
	}
	 public static void overwriteFileContent(String filePath, String newContent) {
	        try {
	            FileWriter fileWriter = new FileWriter(filePath, false);
	            fileWriter.write(""); // Mevcut içeriği siler
	            fileWriter.write(newContent);

	            fileWriter.close();
	            System.out.println("File content has been overwritten.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
}
