import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(features={"features/MathOperations.feature"}, format = {"pretty",  "json:target/cucumber.json"})

public class Driver
{	

}