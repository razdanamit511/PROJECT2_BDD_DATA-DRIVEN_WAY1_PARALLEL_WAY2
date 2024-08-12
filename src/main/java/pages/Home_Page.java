package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigUtils;

public class Home_Page {

	private WebDriver driver;
	ConfigUtils config = new ConfigUtils();

	/* Page Objects/ Object Repository */

	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
	WebElement Settings_Dropdown;

	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	WebElement SignoutButton;

	@FindBy(xpath = "//*[@id='email' or @name='login[username]']")
	WebElement EmailTextbox;

	@FindBy(xpath = "//*[@id='pass' and @name='login[password]']")
	WebElement PasswordTextbox;

	@FindBy(xpath = "//*[@id=\"send2\" and @class='action login primary']")
	WebElement SignInButton;

	@FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a")
	WebElement ForgotPasswordLink;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a")
	WebElement CreateAnAccountButton;

	/* Constructor */
	public Home_Page(WebDriver driver) {

		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/* Page Actions / Action Methods */

	public void OpenHomePage() {
		driver.get(config.getHomePageURL());
	}

	public String GetPageTitle() {
		return driver.getTitle();
	}

	public void ClickSettingsDropdown() {
		Settings_Dropdown.click();
	}

	public void ClickSignoutButton() {
		SignoutButton.click();
	}

	public boolean isEmailTextboxPresent() {
		return EmailTextbox.isDisplayed();
	}

	public boolean isPasswordTextboxPresent() {
		return PasswordTextbox.isDisplayed();
	}

	public boolean isSignInButtonPresent() {
		return SignInButton.isDisplayed();
	}

	public boolean isCreateAnAccountButtonPresent() {
		return CreateAnAccountButton.isDisplayed();
	}

	public boolean isForgotPasswordLinkPresent() {
		return ForgotPasswordLink.isDisplayed();
	}

	public void EnterEmail(String email) {
		EmailTextbox.sendKeys(email);
	}

	public void EnterPassword(String password) {
		PasswordTextbox.sendKeys(password);
	}

	
	public void ClearEmail() {
		EmailTextbox.clear();
	}

	public void ClearPassword() {
		PasswordTextbox.clear();
	}
	
	public void ClickSignInButton() {
		SignInButton.click();
		System.out.println("Clicked SignIn");
	}
}
