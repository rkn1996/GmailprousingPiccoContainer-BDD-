package tests;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;

public class Gmailglue1 
{
	Shared sh;
    public Gmailglue1(Shared sh)
    {
	   this.sh=sh;
    }
	
	@Given("^launch site using \"(.*)\"$")
	public void method2(String bn)
	{
		sh.driver=sh.tu.openBrowser(bn);
		sh.tu.launchsite(sh.driver,sh.p.getProperty("url"));
		sh.hp=new HomePage(sh.driver);
		sh.lp=new LoginPage(sh.driver);
		sh.cp=new ComposePage(sh.driver);
		//create wait object
		sh.wait=new WebDriverWait(sh.driver,20);
		sh.wait.until(ExpectedConditions.visibilityOf(sh.hp.uid));
	}
	
	@Then("^title should be \"(.*)\"$")
	public void method3(String et)
	{
		String at=sh.driver.getTitle();
		if(at.equals(et))
		{
			sh.s.write("Gmail title test passed");
		}
		else
		{
			byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
			sh.s.embed(b,"Gmail title test failed");
			Assert.fail();
		}		
	}
	
	//@When("^close site$")
	//public void method4()
	//{
		//sh.tu.closesite(sh.driver);
	//}
}
