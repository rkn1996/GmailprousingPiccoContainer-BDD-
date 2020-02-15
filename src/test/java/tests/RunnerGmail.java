package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"E:\\Testingtools\\bddfrmwkgmailpicoo\\src\\test\\resources\\gmailfeature\\feature1.feature",
		                   "E:\\Testingtools\\bddfrmwkgmailpicoo\\src\\test\\resources\\gmailfeature\\feature2.feature"
		                  },
                 monochrome=true,
                 tags= {"@tag"},
                 glue= {"classpath:tests"},
                 plugin= {"pretty","html:target\\gmailpicoresults"}
                 )
public class RunnerGmail 
{
	

}
