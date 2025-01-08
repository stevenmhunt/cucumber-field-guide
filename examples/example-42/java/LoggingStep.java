import io.cucumber.java.en.Given;
import org.apache.logging.log4j.Logger;

public class LoggingStep {
    private static final Logger log = LogManager.getLogger(MySteps.class);

    @Given("test values are logged")
    public void given_test_values_are_logged() {
        log.debug("this message will not be seen because of the log level.");
        log.info("this message will be in the file but not shown on the screen.");
        log.warn("this message will be in both the file and on the screen.");
    }
}