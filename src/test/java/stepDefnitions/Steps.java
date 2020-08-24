package stepDefnitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		System.out.println("user is on login page");
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		System.out.println("user enters valid username and password");

	}

	@When("clicks on Login button")
	public void clicks_on_login_button() {
		System.out.println("user clicked on login button");

	}

	@Then("Message should be displayed as login successfull")
	public void message_should_be_displayed_as_login_successfull() {
		System.out.println("login successfully");
	}
}
