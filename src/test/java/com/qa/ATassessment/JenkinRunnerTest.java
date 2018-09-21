package com.qa.ATassessment;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/FridayAssessment.feature")

public class JenkinRunnerTest {

}