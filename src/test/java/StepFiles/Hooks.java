package StepFiles;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumberHelper.TestContext;



import static utility.ConstantVars.*;


public class Hooks {
    public static Scenario scenario;
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void Logging(Scenario scenario) {
        this.scenario = scenario;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        featureName = scenario.getId().split(";")[0];
        System.out.println("-----------------Start of Scenario-----------------");
        System.out.println(scenario.getName());
    }

    @After
    public void afterScenario() {
        System.out.println("-----------------End of Scenario-----------------");
    }

}