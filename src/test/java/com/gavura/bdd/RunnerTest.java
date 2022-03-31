package com.gavura.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.gavura.bdd.stepdefinitions"})
public class RunnerTest extends AbstractTestNGCucumberTests {}