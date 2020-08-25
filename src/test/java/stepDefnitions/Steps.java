package stepDefnitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

	WebDriver driver;
	
	@Before//pre-condition hook //global hooks
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@After//post condition hook // global hooks
	public void tearDown()
	{
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
		
		driver.get("http://localhost/login.do;jsessionid=x1dykgi4yudy");
	}

	@When("user enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String un, String pword) {
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pword);
	}

	@When("clicks on Login button")
	public void clicks_on_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Thread.sleep(2000);

	}

	@Then("Message should be displayed as login successfull {string}")
	public void message_should_be_displayed_as_login_successfull(String eTitle) throws InterruptedException {
		Thread.sleep(2000);
		String atitle = driver.getTitle();
		Assert.assertEquals(eTitle, atitle);
		driver.close();
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

}
