package com.jcst.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features={"src//test//resources//features"},
        glue={
                "com.jcst.definitions",
                "com.jcst.utils"
        },
        plugin= {
                "pretty",
                "json:target/cucumber/cucumber.json",
                "html:target/cucumber/cucumber-html-report.html"
        },
        tags = "@all",
        monochrome = true,
        publish = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

@Test
public class TestRunner extends AbstractTestNGCucumberTests { }
