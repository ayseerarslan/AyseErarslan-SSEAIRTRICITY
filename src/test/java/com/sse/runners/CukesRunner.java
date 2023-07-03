package com.sse.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty", // for getting extra info
                "html:target/cucumber.reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/sse/step_defs",
        dryRun = false,
        tags = "@wip",
        publish = true,
        monochrome = true

)
public class CukesRunner {}
