package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "./src/test/resources/Login.feature",//used to provide path of the feature file
glue = {"stepDefnitions"}//used to provide package name where are steps are implemented

		)
public class TestRunner {

}
