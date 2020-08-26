package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import generic.Base_Page;

public class Enter_TIme_Track_Page extends Base_Page {
	
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	@FindBy(xpath="(//div[@class='popup_menu_arrow'])[3]")
	private WebElement help;
	
	@FindBy(xpath="//a[contains(text(),'About actiTIME')]")
	private WebElement aboutActitime;
	
	@FindBy(xpath="//span[contains(.,'actiTIME 2014 Pro')]")
	private WebElement aVersion;
	
	@FindBy(xpath="//td[@class='close-button']//img")
	private WebElement close;
	
	@FindBy(xpath="//a[contains(text(),'Report a Bug to Vendor')]")
	private WebElement reportBug;
	
	public Enter_TIme_Track_Page(WebDriver driver) {
		super(driver);
	}
	public void clickHelp()
	{
		help.click();
	}
	
	public void clickAboutActitime()
	{
		aboutActitime.click();
	}
	
	public String getActtitimeVersion()
	{
		return aVersion.getText();
	}
	
	public void clickClose()
	{
		close.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
	
	public void clickReportBug()
	{
		reportBug.click();
	}

}
