package com.maestro.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports1.html",
                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-reports/cucumber1.xml"
        },
        features = "src/test/resources/features",
        glue = {"com/maestro/stepDefinitions", "com/maestro/hooks"},
        tags = "@US011",
        dryRun = false


)

public class ParallelRunner1 {

}
