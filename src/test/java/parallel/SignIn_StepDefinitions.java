package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Home_Page;
import pages.SignIn_Page;

public class SignIn_StepDefinitions {

	SignIn_Page spage = new SignIn_Page(DriverFactory.getDriver());
	Home_Page hpage = new Home_Page(DriverFactory.getDriver());

	String title = null;

	@Given("User is on Sign-In page")
	public void user_is_on_sign_in_page() {
		spage.OpenSignInPage();
	}

	@Then("Email label is displayed on sign-in page")
	public void email_label_is_displayed_on_sign_in_page() {
		Assert.assertTrue(spage.isEmailLabelPresent());
	}

	@Then("Email textbox is displayed on sign-in page")
	public void email_textbox_is_displayed_on_sign_in_page() {
		Assert.assertTrue(spage.isEmailTextboxPresent());
	}

	@Then("Password label is displayed on sign-in page")
	public void password_label_is_displayed_on_sign_in_page() {
		Assert.assertTrue(spage.isPasswordLabelPresent());
	}

	@Then("Password textbox is displayed on sign-in page")
	public void password_textbox_is_displayed_on_sign_in_page() {
		Assert.assertTrue(spage.isPasswordTextboxPresent());
	}

	@Then("Forgot Password Link is displayed")
	public void forgot_password_link_is_displayed() {
		Assert.assertTrue(spage.isForgotPasswordLinkPresent());
	}

	@Then("Create An Account button is displayed")
	public void create_an_account_button_is_displayed() {
		Assert.assertTrue(spage.isCreateAnAccountButtonPresent());
	}

	@Then("Sign-In button is displayed")
	public void sign_in_button_is_displayed() {
		Assert.assertTrue(spage.isSignInButtonPresent());
	}

	@When("User enters valid credentials in sign-in form")
	public void user_enters_valid_in_email_textbox(DataTable signincreds) throws InterruptedException {

		// Write the code to handle Data Table
		List<List<String>> data = signincreds.asLists(String.class);

		for (List<String> list : data) {
			System.out.println("User enters " + list.get(0) + " in username textbox");
			System.out.println("User enters " + list.get(1) + " in password textbox");

			System.out.println("Username " + list.get(0));

			spage.EnterEmail(list.get(0));

			System.out.println("Password " + list.get(1));

			spage.EnterPassword(list.get(1));

			Thread.sleep(3000);

			spage.ClickSignInButton();

			Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Home Page");

			Thread.sleep(5000);

			hpage.ClickSettingsDropdown();

			Thread.sleep(5000);

			hpage.ClickSignoutButton();

			Thread.sleep(5000);

			spage.OpenSignInPage();

		}

	}

	@When("User enters invalid credentials in sign-in form")
	public void user_enters_invalid_in_email_textbox(DataTable signincreds) throws InterruptedException {

		// Write the code to handle Data Table
		// List<Map<String,String>> data = signincreds.asMaps(String.class,
		// String.class);

		for (Map<String, String> mapData : signincreds.asMaps(String.class, String.class)) {

			System.out.println("Username " + mapData.get("username"));

			spage.EnterEmail(mapData.get("username"));

			System.out.println("Password " + mapData.get("password"));

			spage.EnterPassword(mapData.get("password"));

			Thread.sleep(3000);

			spage.ClickSignInButton();

			Thread.sleep(3000);

			Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Customer Login");

			Thread.sleep(5000);

			spage.ClearEmail();

			spage.ClearPassword();

		}

	}

	/*
	 * @When("User clicks Sign-In button") public void user_clicks_sign_in_button()
	 * { spage.ClickSignInButton(); }
	 */
}
