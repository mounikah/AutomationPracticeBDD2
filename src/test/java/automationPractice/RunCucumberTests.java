package automationPractice;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features",tags ="@Regression1,@Smoke1,@Smoke2",format="html:target/HtmlCucumberReports")
public class RunCucumberTests {
}
