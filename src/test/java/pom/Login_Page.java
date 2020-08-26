package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import generic.Base_Page;

public class Login_Page extends Base_Page {

	@FindBy(id="username")
	private WebElement unameTxtField;
	
	@FindBy(name="pwd")
	private WebElement pwordTextField;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement login;
	
	@FindBy(className="errormsg")
	private WebElement errMessage;
	
	public Login_Page(WebDriver driver) {
		super(driver);
	}
	
	public void setUsername(String uname)
	{
		unameTxtField.sendKeys(uname);
	}
	
	public void setPassword(String pword)
	{
		pwordTextField.sendKeys(pword);
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public void verifyErrorMessage()
	{
		verifyElement(errMessage, 5);
	}
	
}
