package com.app.sb3t.ws.it;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Launched at verfify step
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = {"pretty", "html:target/reports/cucumber/html",
        "json:target/cucumber.json", "usage:target/usage.json", "junit:target/junit.xml"})
public class CucumberIT {

}
