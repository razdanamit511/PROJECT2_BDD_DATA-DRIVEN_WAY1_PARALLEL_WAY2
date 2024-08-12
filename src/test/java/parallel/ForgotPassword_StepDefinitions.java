package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.ForgotPassword_Page;

public class ForgotPassword_StepDefinitions {

	ForgotPassword_Page forgotpasswordpage = new ForgotPassword_Page(DriverFactory.getDriver());

	@Given("User is on Forgot Password page")
	public void user_is_on_forgot_password_page() {
		DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");
	}

	@Then("Forgot Password label is displayed")
	public void user_get_label() {
		Assert.assertTrue(forgotpasswordpage.isForgotPasswordLabelPresent());
	}

	@Then("Please enter your email address below to receive a password reset link. label is displayed")
	public void user_get_label_message() {
		Assert.assertTrue(forgotpasswordpage.isMessageLabelPresent());
	}

	@Then("Email label")
	public void email_label() {
		Assert.assertTrue(forgotpasswordpage.isEmailLabelPresent());
	}

	@Then("Reset My Password button")
	public void reset_my_password_button() {
		Assert.assertTrue(forgotpasswordpage.isResetMyPasswordButtonPresent());
	}

	@When("User clicks on {string} button")
	public void user_clicks_on_button(String string) {
		forgotpasswordpage.ClickResetMyPasswordButton();
	}

	@When("User enters invalid email in email textbox")
	public void user_enters_invalid_email_textbox(DataTable signincreds) throws InterruptedException {

		// Write the code to handle Data Table
		List<List<String>> data = signincreds.asLists(String.class);

		for (List<String> list : data) {
			System.out.println("User enters " + list.get(0) + " in username textbox");
		//	System.out.println("User enters " + list.get(1) + " in password textbox");

			System.out.println("Username " + list.get(0));

			forgotpasswordpage.EnterEmail(list.get(0));

			Thread.sleep(3000);

			forgotpasswordpage.ClickResetMyPasswordButton();

			Thread.sleep(5000);

			Assert.assertEquals(forgotpasswordpage.getEmailMandatoryMessage(),
					"Please enter a valid email address (Ex: johndoe@domain.com).");

			Thread.sleep(5000);

			forgotpasswordpage.ClearEmail();

			Thread.sleep(3000);
		}

	}

	@Then("Email label is displayed")
	public void Email_label_is_displayed() {
		Assert.assertTrue(forgotpasswordpage.isEmailLabelPresent());
	}

	@Then("Email textbox is displayed")
	public void Email_textbox_is_displayed() {
		Assert.assertTrue(forgotpasswordpage.isEmailTextboxPresent());
	}

	@Then("Reset My Password button is displayed")
	public void Reset_My_Password_button_is_displayed() {
		Assert.assertTrue(forgotpasswordpage.isResetMyPasswordButtonPresent());
	}

	@Then("{string} is displayed under Email textbox")
	public void Mandatory_Message_Email_textbox(String string) {
		Assert.assertEquals(forgotpasswordpage.getEmailMandatoryMessage(), string);
	}

	@Then("User enters valid email in email textbox")
	public void Message_forgot_password_success(DataTable signincreds) throws InterruptedException {

		// Write the code to handle Data Table

		for (Map<String, String> mapData : signincreds.asMaps(String.class, String.class)) {

			System.out.println("Username " + mapData.get("email"));

			forgotpasswordpage.EnterEmail(mapData.get("email"));

			Thread.sleep(3000);

			forgotpasswordpage.ClickResetMyPasswordButton();

			Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Customer Login");

			Assert.assertEquals(forgotpasswordpage.getResetSuccessMessage(),
					"If there is an account associated with razdanamit51@gmail.com you will receive an email with a link to reset your password.");

			Thread.sleep(3000);
			
			forgotpasswordpage.OpenForgotPasswordPage();
		}

	}

}
