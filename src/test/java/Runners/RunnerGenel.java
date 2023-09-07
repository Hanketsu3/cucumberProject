package Runners;



import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src/test/java"},	
		glue = {"stepDefinition"},
				 plugin = { "pretty",
			                "html:target/site/cucumber-pretty",
			                "json:target/cucumber.json","html:target/cucumber-html-report","usage:target/cucumber-usage.json","" +
			                "junit:target/cucumber-results.xml",
			               	},
				 tags ="@smoke",
				 dryRun = false
				
				 
		)

public class RunnerGenel extends AbstractTestNGCucumberTests {
//	@Override
//   @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//       return super.scenarios();
//    }
}