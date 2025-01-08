import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setupTest(Scenario scenario) {
        // run code before each scenario.
    }

    @After
    public void teardownTest(Scenario scenario) {
        // run code after each scenario.
    }

    @BeforeAll
    public static void setup() {
        // run code before all scenarios.
    }

    @AfterAll
    public static void teardown() {
        // run code after all scenarios.
    }

    @BeforeStep
    public void setupTestStep(Scenario scenario) {
        // run code before each step of a scenario.
    }

    @AfterStep
    public void teardownTestStep(Scenario scenario) {
        // run code after each step of a scenario.
    }

    @Before("@smoke and @ui")
    public void setupUISmokeTest(Scenario scenario) {
        // run code before each scenario.
    }

    @After("@smoke and @ui")
    public void teardownSmokeUITest(Scenario scenario) {
        // run code after each scenario.
    }
}