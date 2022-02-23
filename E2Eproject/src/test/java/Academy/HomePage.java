package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class HomePage extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	}
@Test(dataProvider="getData")
public void basePageNavigation(String username,String password,String text) throws IOException
{
	SoftAssert sa=new SoftAssert();	
	driver.get(prop.getProperty("url"));
	LandingPage lp=new LandingPage(driver);
	Assert.assertTrue(lp.getNavigationBar().isDisplayed());
	String title=lp.getTitle().getText();
	sa.assertEquals( title,"FEATURED COURSES");
	LoginPage l=lp.getLogin();
	l.getEmail().sendKeys(username);
	l.getPassword().sendKeys(password);
	System.out.println(text);
	l.getLogin().click();
	sa.assertAll();
}
@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[2][3];
	data[0][0]="nonrestricteduser@qw.com";
	data[0][1]="123456";
	data[0][2]="restricted user";
	data[1][0]="retricteduser@qw.com";
	data[1][1]="456788";
	data[1][2]="nonrestricted user";
	return data;
}
@AfterTest
public void teardown()
{
	driver.close();
	
}
}
