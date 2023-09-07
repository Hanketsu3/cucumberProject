package stepDefinition;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import PageObjectModel.LoginPage;
import PageObjectModel.MainPage;
import PageObjectModel.MyAccountPage;
import PageObjectModel.MyAddressesPage;
import PageObjectModel.YourAddressesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import utilities.Driver1;
public class featureStep {
	
//	public static String headless = "false";
//	public static String browser = "firefox";
	//Paralel çalışmıyo headless tamam.
	public WebDriver driver ;
	@Given("set driver {string}")
	@Step("set driver")
	public void set_driver(String string) {	  
	    driver = Driver1.getDriver();		
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	MainPage mainPage = new MainPage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	MyAddressesPage myAddressesPage = new MyAddressesPage();
	YourAddressesPage yourAddressesPage = new YourAddressesPage();
	@Given("click on login button")
	@Step("click on login button")
	public void click_on_login_button() {
	  mainPage.clickLoginButton();
	}

	@Given("type email")
	@Step("type email")
	public void type_email() throws FileNotFoundException {
	
	   loginPage.typeEmail();
	}

	@Given("type password")
	@Step("type password")
	public void type_password() throws FileNotFoundException {
	    loginPage.typePassword();
	}

	@Given("click on submit button")
	@Step("click on submit button")
	public void click_on_submit_button() {
	    loginPage.clickOnSubmitButton();
	}

	@Given("click on My Addresses")
	@Step("click on My Addresses")
	public void click_on_my_addresses() {
	   myAccountPage.clickOnMyAddresses();
	}

	@Given("click on Add a new address")
	@Step("click on Add a new address")
	public void click_on_add_a_new_address() {
	    myAddressesPage.clickOnAddAddressButton();
	}

	
	@Step("type Address")
	@Given("type address {string}")
	public void type_address(String string) {
		yourAddressesPage.typeAddress(string);
	}

	@Given("type City")
	@Step("type City")
	public void type_city() {
	   yourAddressesPage.typeCity();
	}

	@Given("select State from dropdown")
	@Step("select State from dropdown")
	public void select_state_from_dropdown() {
	   yourAddressesPage.slcState();
	}
	@Given("scroll down")
	@Step("scroll down")
    public void scroll_down() {
    	scrollPage(0,500);
    }
	@Given("type Zip Code")
	@Step("type Zip Code")
	public void type_zip_code() {
	   yourAddressesPage.typePostCode();
	}

	@Given("type Home Phone")
	@Step("type Home Phone")
	public void type_home_phone() {
		yourAddressesPage.typePhone();
	}
	@Given("type Address Name")
	@Step("type Address Name")
	public void type_Address_Name() throws FileNotFoundException {
		yourAddressesPage.typeAddressName();
	}
	

	@Given("Click On Save button")
	@Step("Click On Save button")
	public void click_on_save_button() {
	   yourAddressesPage.clickOnSave();
	}

	@Then("verify message")
	@Step("verify message")
	public void verify_message() {
	    myAddressesPage.assertText();
	}

	
	
	
	private void scrollPage(int xOffset, int yOffset) {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        String script = String.format("window.scrollBy(%d, %d)", xOffset, yOffset);
	        jsExecutor.executeScript(script);
	}
	


}
