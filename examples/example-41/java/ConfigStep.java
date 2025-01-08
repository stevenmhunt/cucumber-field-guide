import com.typesafe.config.*;
import io.cucumber.java.en.Given;

public class ConfigStep {
    
    @Given("a test value is printed")
    public void given_a_test_value_is_printed() {
        Config config = ConfigFactory.load(System.getEnv("TEST_ENV"));
        System.out.println(config.getString("steps.testValue"));
    }
} {
    
}
