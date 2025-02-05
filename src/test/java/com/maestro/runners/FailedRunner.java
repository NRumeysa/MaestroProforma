package com.maestro.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  //Cucumber, çalıştır, RUN ET!
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-reports/cucumber.xml",
                "rerun:TestOutput/failed_scenario.txt"
        },
        features = "@TestOutput/failed_scenario.txt",
        glue = {"com/maestro/stepDefinitions", "com/maestro/hooks"},
        dryRun = false


)

public class FailedRunner {
}