package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(
		features="src/test/java/features/placeValidations.feature",
		glue= {"stepDefinitions"}
		)

public class TestRunner {
}


