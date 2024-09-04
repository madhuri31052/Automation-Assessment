package stepDefinitions;

// To maintain many feature files we create this file

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/", 
glue= {"stepDefinitions"}, 
monochrome = true
//tags = "@smokeTests and @regressionTests"
)

public class TestRunner {

    public static void main(String[] args) {
        
    }
 
}