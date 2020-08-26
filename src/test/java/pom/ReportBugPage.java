package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class ReportBugPage extends Base_Page {

	@FindBy(xpath = "//textarea[@id='bug']")
	private WebElement textArea;

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='emailAddress']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='companyName']")
	private WebElement company;

	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement send;
	
	public ReportBugPage(WebDriver driver)
	{
		super(driver);
	}

	public void enterBugDescription(String description)
	{
		textArea.sendKeys(description);
	}
	
	public void enterFirstName(String fn)
	{
		firstName.sendKeys(fn);
	}
	
	public void enterLastName(String ln)
	{
		lastName.sendKeys(ln);
	}
	
	public void enterEmail(String emailer)
	{
		email.sendKeys(emailer);
	}
	
	public void enterCompany(String companyName)
	{
		company.sendKeys(companyName);
	}
	
	public void clickSend()
	{
		send.click();
	}
}
