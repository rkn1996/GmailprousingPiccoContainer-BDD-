package tests;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Gmailglue3 
{
	Shared sh;
    public Gmailglue3(Shared sh)
    {
    	this.sh=sh;
    }
    
    @And("^enter \"(.*)\" as password$")
	public void method8(String x)
	{
		sh.lp.pwdfill(x);
		sh.wait.until(ExpectedConditions.elementToBeClickable(sh.lp.pwdnext));
	}
	
	@And("^click pwd next$")
	public void method9() throws Exception
	{
		sh.lp.pwdnextclick();
		Thread.sleep(5000);
	}
	
	@Then("^validate output for \"(.*)\" as pwd criteria$")
	public void method10(String c)
	{
		try
		{
			if(c.equalsIgnoreCase("blank") && sh.lp.blankpwderr.isDisplayed())
			{
				sh.s.write("pwd test passed for blank password");
			}
			else if(c.equalsIgnoreCase("invalid") && sh.lp.invalidpwderr.isDisplayed())
			{
				sh.s.write("pwd test passed for invalid password");
			}
			else if(c.equalsIgnoreCase("valid") && sh.cp.comp.isDisplayed())
			{
				sh.s.write("pwd test passed for valid password");
				//do logout
				sh.cp.profilepicclick();
				sh.wait.until(ExpectedConditions.elementToBeClickable(sh.cp.signout));
				sh.cp.signoutclick();
			}
			else
			{
				byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
				sh.s.embed(b,"PWD test failed");
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
