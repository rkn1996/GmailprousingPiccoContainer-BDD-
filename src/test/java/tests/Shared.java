package tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import utility.TestUtility;

public class Shared 
{
	public WebDriver driver;
	public Scenario s;
	public TestUtility tu;
	public LoginPage lp;
	public HomePage hp;
	public ComposePage cp;
	public Properties p;
	public WebDriverWait wait;
	
	@Before
	public void init(Scenario s) throws Exception
	{
		this.s=s;
		File f=new File("E:\\Testingtools\\bddfrmwkgmail\\src\\test\\resources\\gmailproperties\\gmailproperties.properties");
		FileReader fr=new FileReader(f);
		p=new Properties();
		p.load(fr);
		tu=new TestUtility();
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
		cp=new ComposePage(driver);	
	}
	
	@After
	public void cleanUp()
	{
		tu.closesite(driver);
	}

}
