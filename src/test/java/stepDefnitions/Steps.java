package stepDefnitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.FileManager;
import generic.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Enter_TIme_Track_Page;
import pom.Login_Page;
import pom.ReportBugPage;

public class Steps {

	WebDriver driver;
	FileManager fm=new FileManager();
	Login_Page lp;
	Enter_TIme_Track_Page ep;
	ReportBugPage rbp;
	
	@Before//pre-condition hook //global hooks
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(fm.getQATUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(fm.getImplicitlyWait(), TimeUnit.SECONDS);
		lp=new Login_Page(driver);
		ep=new Enter_TIme_Track_Page(driver);
		rbp=new ReportBugPage(driver);
		
	}
	
	@After//post condition hook // global hooks
	public void tearDown(Scenario scenario)
	{
		String testName = scenario.getName();
		if(scenario.isFailed())
		{
			new Screenshot().capture(driver, testName);
		}
		driver.quit();
	}
	
	@Before("@smoke")//pre-conditional hooks
	public void setUpMobile()
	{
		System.out.println("start in mobile env");
	}
	
	@After("@smoke")//post-conditional hooks
	public void tearDownMobile()
	{
		System.out.println("close in mobile env");
	}

	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		
		System.out.println("user is on login page");
	
	}

	@When("user enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String un, String pword) {
		lp.setUsername(un);
		lp.setPassword(pword);
		
	}

	@When("clicks on Login button")
	public void clicks_on_login_button() throws InterruptedException {
		lp.clickLogin();

	}

	@Then("Message should be displayed as login successfull {string}")
	public void message_should_be_displayed_as_login_successfull(String eTitle) throws InterruptedException {
		Thread.sleep(2000);
		String atitle = driver.getTitle();
		Assert.assertEquals(eTitle, atitle);
	}

	@Given("select payment {string} type")
	public void select_payment_type(String string) {
		System.out.println(string);
	}

	@Then("order is placed successfully")
	public void order_is_placed_successfully(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> val = dataTable.asMaps(String.class, String.class);

		for (int i = 0; i < val.size(); i++) {
			String value = val.get(i).get("mode");
			String discount = val.get(i).get("discount");
			String cashback = val.get(i).get("cashback");

			System.out.println(value + "-" + discount + "-" + cashback);
		}
	}
	
	@When("user cliks on help")
	public void user_cliks_on_help() {
	 ep.clickHelp();
	}


	@When("user clicks on About actitime")
	public void user_clicks_on_about_actitime() {
	   ep.clickAboutActitime();
	}
	@When("verify the Acti time version {string}")
	public void verify_the_acti_time_version(String eVersion) {
	    String aVersion = ep.getActtitimeVersion();
	    Assert.assertEquals(eVersion, aVersion);
	}
	@When("user clicks on close")
	public void user_clicks_on_close() {
	    ep.clickClose();
	}
	@When("user cliks on logout")
	public void user_cliks_on_logout() {
	   ep.clickLogout();
	}
	@Then("login page should be displayed")
	public void login_page_should_be_displayed() {
	    ep.verifyTitle("Login", 5);
	    System.out.println(driver.getTitle());
	}

	@When("user clicks on report")
	public void user_clicks_on_report() {
	  ep.clickReportBug();
	  ep.switchToWindow();
	}


	@When("user enters description {string}")
	public void user_enters_description(String desc) {
	    rbp.enterBugDescription(desc);
	}
	@When("user enters first name {string}")
	public void user_enters_first_name(String fn) {
	    rbp.enterFirstName(fn);
	}
	@When("user enters last name {string}")
	public void user_enters_last_name(String ln) {
	    rbp.enterLastName(ln);
	}
	@When("user enters email {string}")
	public void user_enters_email(String emailer) {
	   rbp.enterEmail(emailer);
	}
	@When("use enters company {string}")
	public void use_enters_company(String companyName) {
	    rbp.enterCompany(companyName);
	}
	@When("users cliks on send report")
	public void users_cliks_on_send_report() {
	  rbp.clickSend();
	}
	@Then("Bug report should be submitted successfully")
	public void bug_report_should_be_submitted_successfully() {
	   System.out.println("Reported submitted successfully");
	}
}
