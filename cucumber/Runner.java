import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/SI20466403/eclipse-workspace/CapstoneTutorialsNinja/cucumber/features/test04.feature", glue = "bindings", plugin = {
		"pretty",
		"html:/Users/SI20466403/eclipse-workspace/CapstoneTutorialsNinja/src/test/resources/CucumberTestReports/TC04Report.html" })
public class Runner extends AbstractTestNGCucumberTests {

}
