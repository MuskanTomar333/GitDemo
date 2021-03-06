package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
public WebDriver driver;
public LandingPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[contains(@href,'sign_in')]")
WebElement signin;
//By signin=By.cssSelector("a[href*='sign_in']");
@FindBy(xpath="//div[@class='text-center']/h2")
WebElement title;
@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']")
WebElement navBar;
public LoginPage getLogin()
{
	//return driver.findElement(signin);
	 signin.click();
	 LoginPage l=new LoginPage(driver);
	 return l;
}
public WebElement getTitle()
{
	return title;
}
public WebElement getNavigationBar()
{
	return navBar;
}
}
