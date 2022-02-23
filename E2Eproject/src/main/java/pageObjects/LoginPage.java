package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user_email")
	WebElement email;
	@FindBy(id="user_password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	public WebElement getEmail()
	{
		return email;
	}
	public WebElement getPassword()
	{
		return password;
	}
	public WebElement getLogin()
	{
		return login;
	}
}
