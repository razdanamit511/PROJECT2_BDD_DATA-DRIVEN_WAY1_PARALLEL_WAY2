package parallel;


import org.testng.Assert;
import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignIn_Page;

public class Background_StepDefinitions {
	SignIn_Page sp = new SignIn_Page(DriverFactory.getDriver());
	// CreateAnAccountPage capg = new
	// CreateAnAccountPage(DriverFactory.getDriver());

	String title = null;

	@When("User gets the page title")
	public void user_gets_the_page_title() {
		title = DriverFactory.getDriver().getTitle();
		System.out.println("Title :" + title);
	}

	@Then("title of the page is {string}")
	public void title_of_the_page_is(String string) {
		Assert.assertEquals(title, string);
	}

}
