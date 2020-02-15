package tests;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Gmailglue2 
{
	Shared sh;
    public Gmailglue2(Shared sh)
    {
	   this.sh=sh;
    }
    @When("^enter \"(.*)\" as userid$")
	public void method5(String x)
	{
		sh.hp.uidfill(x);
		sh.wait.until(ExpectedConditions.elementToBeClickable(sh.hp.uidnext));
	}
	
	@And("^click uid next$")
	public void method6() throws Exception
	{
		sh.hp.uidnextclick();
		Thread.sleep(5000);
	}
	
	@Then("^validate output for \"(.*)\" as uid criteria$")
	public void method7(String c)
	{
		try
		{
			if(c.equalsIgnoreCase("blank") && sh.hp.blankuiderr.isDisplayed())
			{
				sh.s.write("uid test passed for blank uid");
			}
			else if(c.equalsIgnoreCase("invalid") && sh.hp.invaliduiderr.isDisplayed())
			{
				sh.s.write("uid test passed for invalid uid");
			}
			else if(c.equalsIgnoreCase("valid") && sh.lp.pwd.isDisplayed())
			{
				sh.s.write("uid test passed for valid uid");
			}
			else
			{
				byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
				sh.s.embed(b,"UID test failed");
				Assert.fail();
			}
		}
		catch(Exception ex)
		{
			byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
			sh.s.embed(b,ex.getMessage());
			Assert.fail();
		}
	}
    
}
